import org.junit.Assert.assertEquals
import org.junit.Test

class ChatServiceTest {
    class ChatServiceTest {
        @Test
        fun testCreateChat() {
            // Arrange
            val chatService = ChatService()
            val user1 = ChatService.User("1", "User 1")
            val user2 = ChatService.User("2", "User 2")

            // Act
            chatService.createChat("user1", "user2")
            val chats = chatService.getChats("1")
        }

        @Test
        fun testDeleteChat() {
            // Arrange
            val chatService = ChatService()
            val user1 = ChatService.User("1", "User 1")
            val user2 = ChatService.User("2", "User 2")
            chatService.createChat("user1", "user2")
            val chatsBeforeDeletion = chatService.getChats("1")

            // Act
            val chatToDelete = chatsBeforeDeletion.first(predicate = { it.id == "1" })
            chatService.deleteChat(chatToDelete.id)
            val chatsAfterDeletion = chatService.getChats("1")

            // Assert
            assertEquals(chatsBeforeDeletion.size - 1, chatsAfterDeletion.size)
            assertEquals(false, chatsAfterDeletion.contains(chatToDelete))
        }
    }
}
