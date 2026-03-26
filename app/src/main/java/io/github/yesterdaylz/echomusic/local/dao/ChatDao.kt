package io.github.yesterdaylz.echomusic.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.github.yesterdaylz.echomusic.local.entity.ChatMessageEntity

@Dao
interface ChatDao {
    @Query("SELECT * FROM chat_message WHERE sessionId = :sessionId ORDER BY id ASC")
    suspend fun getBySessionId(sessionId: Long): List<ChatMessageEntity>

    @Insert
    suspend fun insert(entity: ChatMessageEntity)


    @Query("DELETE FROM chat_message WHERE sessionId = :sessionId")
    suspend fun clearBySessionId(sessionId: Long)
}