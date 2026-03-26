package io.github.yesterdaylz.echomusic.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.yesterdaylz.echomusic.local.dao.ChatDao
import io.github.yesterdaylz.echomusic.local.dao.ChatSessionDao
import io.github.yesterdaylz.echomusic.local.dao.FavoriteDao
import io.github.yesterdaylz.echomusic.local.dao.HistoryDao
import io.github.yesterdaylz.echomusic.local.dao.SearchHistoryDao
import io.github.yesterdaylz.echomusic.local.dao.UserDao
import io.github.yesterdaylz.echomusic.local.entity.ChatMessageEntity
import io.github.yesterdaylz.echomusic.local.entity.ChatSessionEntity
import io.github.yesterdaylz.echomusic.local.entity.FavoriteSongEntity
import io.github.yesterdaylz.echomusic.local.entity.HistorySongEntity
import io.github.yesterdaylz.echomusic.local.entity.SearchHistoryEntity
import io.github.yesterdaylz.echomusic.local.entity.UserEntity

@Database(entities = [ChatMessageEntity::class,
    ChatSessionEntity::class,
    ], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chatSessionDao(): ChatSessionDao
    abstract fun chatDao(): ChatDao


    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "echo_music.db"
                ).fallbackToDestructiveMigration(false)
                    .build().also { INSTANCE = it }
            }
        }
    }
}