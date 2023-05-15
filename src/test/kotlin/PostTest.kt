@file:Suppress("AssertBetweenInconvertibleTypes")

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class PostTest {
    @Test
    fun testPost() {
        val post = Post(
            1, 2, 3, emptyArray(), true, "text", true, 10, 5, "Simple",
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            isFavorite = false,
            id = 1,
            emptyArray(),
        )

        assertEquals(1, post.ownerId)
        assertEquals(2, post.fromId)
//        assertEquals(/* expected = */ 3, /* actual = */ post.createdBy)
       // assertEquals(1, post.original)
        assertEquals("text", post.text)
        assertEquals(true, post.friendsOnly)
        assertEquals(10, post.likes)
        assertEquals(5, post.reposts)
        assertEquals("Simple", post.postType)
        assertEquals(true, post.canPin)
        assertEquals(true, post.canDelete)
        assertEquals(true, post.canEdit)
        assertEquals(false, post.isPinned)
        assertEquals(false, post.isFavorite)
        assertEquals(1, post.id)
    }
    @Test
    fun testEquals() {
        val post1 = Post(
            1, 2, 3, emptyArray(), true, "text", true, 10, 5, "Simple",
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            isFavorite = false,
            id = 1,
            emptyArray(),
        )
        val post2 = Post(
            1, 2, 3, emptyArray(), false, "text", true, 10, 5, "Simple", true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            isFavorite = false,
            id = 1,
            emptyArray(),
            )
        val post3 = Post(
            2, 3, 4, emptyArray(), false, "text", true, 20, 10, "Simple",
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            isFavorite = false,
            id = 2,
            emptyArray(),
            )

//        assertEquals(/* expected = */ post1, /* actual = */ post2)
        assertNotEquals(post1, post3)
    }

    @Test
    fun testCopy() {
        val post1 = Post(
            1,
            2,
            3,
            emptyArray(),
            true,
            "text",
            true,
            10,
            5,
            "Simple",
            true,
            true,
            true,
            false,
            false,
            1,
            emptyArray(),
        )
        val post2 = post1.copy()

        assertEquals(post1, post2)
    }

    @Test
    fun testToString() {
        Post(
            1,
            2,
            3,
            emptyArray(),
            true,
            "text",
            true,
            10,
            5,
            "Simple",
            true,
            true,
            true,
            false,
            false,
            1,
            emptyArray(),
            )
    }
}