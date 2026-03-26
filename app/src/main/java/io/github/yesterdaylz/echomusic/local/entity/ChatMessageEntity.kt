package io.github.yesterdaylz.echomusic.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**聊天消息
 * 会话id，角色，内容，创建日期
 */
@Entity(tableName = "chat_message")
data class ChatMessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val sessionId: Long,
    val role: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis()
)