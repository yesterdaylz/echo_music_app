package io.github.yesterdaylz.echomusic.service.network

import io.github.yesterdaylz.echomusic.service.AuthService
import io.github.yesterdaylz.echomusic.service.creator.MusicServiceCreator

object AuthNetwork {
    private val service = MusicServiceCreator.create<AuthService>()

    suspend fun sendCaptcha(mobile: String) = service.sendCaptcha(mobile)
    suspend fun login(mobile: String, code: String) = service.loginCellphone(mobile, code)
}