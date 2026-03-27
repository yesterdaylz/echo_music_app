package io.github.yesterdaylz.echomusic.model.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CaptchaSentResponse(
    val status: Int,
    val error_code: Int
)

@JsonClass(generateAdapter = true)
data class LoginCellphoneResponse(
    val data: LoginData?,
    val status: Int,
    val error_code: Int
)

@JsonClass(generateAdapter = true)
data class LoginData(
    val userid: Long,
    val token: String,
    val nickname: String? = null,
    val pic: String? = null,
    val servertime: String? = null
)
@JsonClass(generateAdapter = true)
data class SongMetaInfo(
    val duration: Long? = null,
    val image: String? = null,
    val imgsize: List<Int>? = null,
    val tracker_url: List<String>? = null
)