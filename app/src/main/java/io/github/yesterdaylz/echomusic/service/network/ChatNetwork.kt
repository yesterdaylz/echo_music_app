package io.github.yesterdaylz.echomusic.service.network

import com.squareup.moshi.Moshi
import io.github.yesterdaylz.echomusic.model.ai.ChatRequest
import io.github.yesterdaylz.echomusic.model.ai.StreamChunk
import io.github.yesterdaylz.echomusic.service.ChatService
import io.github.yesterdaylz.echomusic.service.creator.ServiceCreator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.BufferedSource

object ChatNetwork {

    private val service = ServiceCreator.create<ChatService>()
    private val moshi = Moshi.Builder().build()
    private val chunkAdapter = moshi.adapter(StreamChunk::class.java)

    suspend fun chat(req: ChatRequest) = service.chat(req)
    fun chatStream(req: ChatRequest): Flow<String> = flow {
        val resp = service.chatStream(req)
        if (!resp.isSuccessful) {
            throw RuntimeException("HTTP ${resp.code()} ${resp.message()}")
        }

        val body = resp.body() ?: throw RuntimeException("Empty body")
        val source: BufferedSource = body.source()

        while (!source.exhausted()) {
            val line = source.readUtf8Line() ?: continue
            if (!line.startsWith("data:")) continue

            val data = line.removePrefix("data:").trim()
            if (data == "[DONE]") break
            if (data.isEmpty()) continue

            // 解析每个 chunk 的 JSON
            val chunk = chunkAdapter.fromJson(data) ?: continue
            val deltaText = chunk.choices?.firstOrNull()?.delta?.content

            if (!deltaText.isNullOrEmpty()) {
                emit(deltaText)
            }
        }
    }
}