package io.github.yesterdaylz.echomusic.service

import io.github.yesterdaylz.echomusic.model.ai.ChatRequest
import io.github.yesterdaylz.echomusic.model.ai.ChatResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Streaming

interface ChatService {
    @Streaming//流式请求
    @POST("chat/completions")
    suspend fun chatStream(@Body req: ChatRequest): Response<ResponseBody>
    @POST("chat/completions")
    suspend fun chat(@Body req: ChatRequest): ChatResponse
}