import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class PostTest {
    @Test
    fun testEquals() {
        val post1 = Post(1, 2, 3, emptyArray(), null, "text", true, 10, 5, "Simple", true, true, true, false, false, 1)
        val post2 = Post(1, 2, 3, emptyArray(), null, "text", true, 10, 5, "Simple", true, true, true, false, false, 1)
        val post3 = Post(2, 3, 4, emptyArray(), null, "text", true, 20, 10, "Simple", true, true, true, false, false, 2)

        assertEquals(post1, post2)
        assertNotEquals(post1, post3)
    }

    @Test
    fun testCopy() {
        val post1 = Post(1, 2, 3, emptyArray(), null, "text", true, 10, 5, "Simple", true, true, true, false, false, 1)
        val post2 = post1.copy()

        assertEquals(post1, post2)
    }

    @Test
    fun testToString() {
        val post = Post(1, 2, 3, emptyArray(), null, "text", true, 10, 5, "Simple", true, true, true, false, false, 1)

        val expectedOutput = "Post(ownerId=1, fromId=2, createdBy=3, attachments=[], original=null, text=text, friendsOnly=true, likes=10, reposts=5, postType=Simple, canPin=true, canDelete=true, canEdit=true, isPinned=false, isFavorite=false, id=1)"
        assertEquals(expectedOutput, post.toString())
    }
}