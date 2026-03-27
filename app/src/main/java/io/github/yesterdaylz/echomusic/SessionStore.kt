package io.github.yesterdaylz.echomusic

object SessionStore {
    @Volatile var token: String? = null
    @Volatile var userId: Long? = null
    @Volatile var dfid: String? = null
}