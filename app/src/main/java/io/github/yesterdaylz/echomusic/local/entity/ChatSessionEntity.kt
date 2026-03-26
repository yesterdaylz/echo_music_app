package io.github.yesterdaylz.echomusic.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 会话
 * id,会话名称，置顶，创建时间，重新时间
 */
@Entity(tableName = "chat_session")
data class ChatSessionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val isPinned: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)