import org.junit.Test
import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class WallServiceTest {

    @Test
    fun testAdd() {
        val post1 = Post(1, 2, 3, emptyArray(), null, "text1", true, 10, 5, "Simple", true, true, true, false, false, 1)
        val post2 = Post(2, 3, 4, emptyArray(), null, "text2", true, 20, 10, "Simple", true, true, true, false, false, 2)

        WallService.add(post1)
        WallService.add(post2)

        assertEquals(post1, WallService.posts[0])
        assertEquals(post2, WallService.posts[1])
    }

    @Test
    fun testUpdate() {
        val post1 = Post(1, 2, 3, emptyArray(), null, "text1", true, 10, 5, "Simple", true, true, true, false, false, 1)
        val post2 = Post(2, 3, 4, emptyArray(), null, "text2", true, 20, 10, "Simple", true, true, true, false, false, 2)

        WallService.add(post1)
        WallService.add(post2)

        val updatedPost = post2.copy(text = "updated text")
        val result = WallService.update(updatedPost)

        assertTrue(result)
        assertEquals(updatedPost, WallService.posts[1])
    }

    @Test
    fun testPrintAll() {
        val post1 = Post(1, 2, 3, emptyArray(), null, "text1", true, 10, 5, "Simple", true, true, true, false, false, 1)
        val post2 = Post(2, 3, 4, emptyArray(), null, "text2", true, 20, 10, "Simple", true, true, true, false, false, 2)

        WallService.add(post1)
        WallService.add(post2)

        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        WallService.printAll()

        val expectedOutput = "${post1}\n${post2}\n"
        assertNotEquals(expectedOutput, outContent.toString().replace("\r\n", "\n"))
    }

}
