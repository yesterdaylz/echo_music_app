package io.github.yesterdaylz.echomusic.model.ai

import com.squareup.moshi.JsonClass

//请求体
@JsonClass(generateAdapter = true)
data class ChatRequest(
    val model: String = "deepseek-chat",
    val messages: List<Message>,
    val stream: Boolean = false
)
@JsonClass(generateAdapter = true)
data class Message(
    val role: String,
    val content: String
)

//流式输出
@JsonClass(generateAdapter = true)
data class StreamChunk(
    val choices: List<StreamChoice>?
)

@JsonClass(generateAdapter = true)
data class StreamChoice(
    val delta: Delta?
)

@JsonClass(generateAdapter = true)
data class Delta(
    val role: String? = null,
    val content: String? = null
)


//非流
@JsonClass(generateAdapter = true)
data class ChatResponse(
    val choices: List<Choice>?
)

@JsonClass(generateAdapter = true)
data class Choice(
    val message: Message?
)