import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class WallServiceTest
{

    @Before
    fun setUp()
    {
        WallService.clear()
    }

    @After
    fun tearDown()
    {
        WallService.clear()
    }

    @Test
    fun testAdd()
    {
        val post1 = Post(1,2,3,emptyArray(),true,"text1",true,10,5,"Simple",true,true,true,false,false,1,emptyArray())
        val post2 = Post(2,3,4,emptyArray(),true,"text2",true,20,10,"Simple",true,true,true,false,false,2,emptyArray())

        WallService.add(post1)
        WallService.add(post2)

        assertEquals(post1,WallService.posts[0])
        assertEquals(post2,WallService.posts[1])
    }

    @Test
    fun testUpdate()
    {
        val post1 = Post(1,2,3,emptyArray(),true,"text1",true,10,5,"Simple",true,true,true,false,false,1,emptyArray())
        val post2 = Post(2,3,4,emptyArray(),true,"text2",true,20,10,"Simple",true,true,true,false,false,2,emptyArray())

        WallService.add(post1)
        WallService.add(post2)

        val updatedPost = post2.copy(text = "updated text")
        val result = WallService.update(updatedPost)

        assertTrue(result)
        assertEquals(updatedPost,WallService.posts[1])
    }

    @Test
    fun testPrintAll()
    {
        val post1 = Post(1,2,3,emptyArray(),true,"text1",true,10,5,"Simple",true,true,true,false,false,1,emptyArray())
        val post2 = Post(2,3,4,emptyArray(),true,"text2",true,20,10,"Simple",true,true,true,false,false,2,emptyArray())

        WallService.add(post1)
        WallService.add(post2)

        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        WallService.printAll()

        val expectedOutput = "${post1}\n${post2}\n"
        assertEquals(expectedOutput,outContent.toString().replace("\r\n","\n"))
    }

    @Test
    fun testCreateComment()
    {
        val post = Post(1,1,1,emptyArray(),true,"Новый пост",false,0,0,"",true,true,true,false,false,1,emptyArray())

        WallService.add(post)

        val comment = Comment(postId = post.id,fromId = 2,text = "Новый комментарий",date = 1,donut = null,replyToUser = null,replyToComment = null,attachments = null,parentsStack = 1,thread = null,likes = 0,id = 1)

        WallService.createComment(post.id,comment)

        assertEquals(1,WallService.posts[0].comments.size)

    }

    @Test
    fun `createCommentThrow`()
    {
        val post = Post(2,2,2,emptyArray(),true,"Test",false,0,0,"",true,true,true,false,false,1,emptyArray())
        WallService.add(post)
        assertThrows(PostNotFoundException::class.java) {
            WallService.createComment(2,
                        Comment(0,0,1,"Comment",1,1,1,1,1,1,1,1))
        }
    }

    @Test
    fun `createCommentAdd`()
    {
        val post = Post(2,2,2,emptyArray(),true,"Test",false,0,0,"",true,true,true,false,false,1,emptyArray())
        WallService.add(post)
        val comment = Comment(0,0,1,"Comment",1,1,1,1,1,1,1,1)
        val newComment = WallService.createComment(1,comment)
        assertEquals(1,WallService.posts.first().comments.size)
        assertEquals(newComment,WallService.posts.first().comments.first())
        assertEquals(newComment,WallService.comments.first())
    }
}
