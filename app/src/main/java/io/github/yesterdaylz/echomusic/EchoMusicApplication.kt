package io.github.yesterdaylz.echomusic

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import io.github.yesterdaylz.echomusic.key.Key
import kotlinx.serialization.Contextual

@HiltAndroidApp
class EchoMusicApplication : Application() {
    companion object{
        const val KEY = Key.deepseekKey
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}