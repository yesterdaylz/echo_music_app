package io.github.yesterdaylz.echomusic.service

import io.github.yesterdaylz.echomusic.model.auth.CaptchaSentResponse
import io.github.yesterdaylz.echomusic.model.auth.LoginCellphoneResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthService {
    //验证码发送
    @GET("captcha/sent")
    suspend fun sendCaptcha(@Query("mobile") mobile: String): CaptchaSentResponse
    //手机登录
    @GET("login/cellphone")
    suspend fun loginCellphone(
        @Query("mobile") mobile: String,
        @Query("code") code: String
    ): LoginCellphoneResponse
}