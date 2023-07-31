import java.util.*

class ChatService {
    private val chats: MutableList<Chat> = mutableListOf()

    fun createChat(userId1: String, userId2: String) {
        val user1 = User(userId1, "Первый пользователь")
        val user2 = User(userId2, "Второй пользователь")
        val chat = Chat(user1, user2)
        chats.add(chat)
    }

    fun deleteChat(chatId: String) {
        val chat = chats.find { it.id == chatId }
        if (chat != null) {
            chats.remove(chat)
        }
    }

    fun getChats(userId: String): List<Chat> {
        return chats.filter { it.hasUser(userId) }
    }

    fun getUnreadChatsCount(userId: String): Int {
        return chats.count { it.hasUnreadMessages(userId) }
    }

    fun getLastMessages(userId: String): List<String> {
        return chats.mapNotNull { chat ->
            chat.getLastMessage()?.let { message ->
                if (chat.hasUser(userId)) {
                    message.content
                } else {
                    null
                }
            } ?: "нет сообщений"
        }
    }

    fun getMessagesFromChat(chatId: String, lastMessageId: String, count: Int): List<Message> {
        val chat = chats.find { it.id == chatId }
        if (chat != null) {
            return chat.getMessagesFrom(lastMessageId, count)
        }
        return emptyList()
    }

    fun sendMessage(userId: String, chatId: String, content: String) {
        val chat = chats.find { it.id == chatId }
        if (chat != null) {
            chat.sendMessage(userId, content)
        }
    }

    fun deleteMessage(chatId: String, messageId: String) {
        val chat = chats.find { it.id == chatId }
        if (chat != null) {
            chat.deleteMessage(messageId)
        }
    }

    class Chat(val user1: User, val user2: User) {
        private val messages: MutableList<Message> = mutableListOf()
        private var unreadCount: Int = 0
        val id: String = UUID.randomUUID().toString()

        fun sendMessage(senderId: String, content: String) {
            val sender = User(senderId, "")
            val message = Message(sender, content)
            messages.add(message)
            if (sender != user1) {
                unreadCount++
            }
        }

        fun deleteMessage(messageId: String) {
            val message = messages.find { it.id == messageId }
            if (message != null) {
                messages.remove(message)
            }
        }

        fun getMessages(): List<Message> {
            return messages
        }

        fun hasUser(userId: String): Boolean {
            return user1.id == userId || user2.id == userId
        }

        fun hasUnreadMessages(userId: String): Boolean {
            return userId != user1.id && unreadCount > 0
        }

        fun getLastMessage(): Message? {
            return messages.lastOrNull()
        }

        fun getMessagesFrom(lastMessageId: String, count: Int): List<Message> {
            val startIndex = messages.indexOfFirst { it.id == lastMessageId } + 1
            val endIndex = startIndex + count
            return messages.subList(startIndex, endIndex).also {
                it.forEach { message -> message.isRead = true }
            }
        }
    }

    //В задаче явно требуются классы User и Message, пока оставлю заглушку здесь.

    data class User(val id: String, val name: String)

    data class Message(val sender: User, var content: String) {
        val id: String = UUID.randomUUID().toString()
        var isRead: Boolean = false
    }
}