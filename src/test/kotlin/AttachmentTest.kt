import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test


class AttachmentTest {
    @Test
    fun testToString() {
        val attachment = PhotoAttachment("image", "https://example.com/image.jpg", 599, 300)
        assertEquals("PhotoAttachment(type=image, url=https://example.com/image.jpg, width=599, height=300)", attachment.toString())
    }

    @Test
    fun testEquals() {
        val attachment1 = PhotoAttachment("image", "https://example.com/image.jpg", 1000, 1499)
        val attachment2 = VideoAttachment("video", "Youtube", "https//&*/,com", 1080, 1920)
        val attachment3 = DocumentAttachment("doc", "Excel", "https//&*/,com")

      //  assertEquals(attachment1, attachment2)
        assertNotEquals(attachment1, attachment3)
    }

    @Test
    fun testHashCode() {
        val attachment1 = PhotoAttachment("image", "https://example.com/image.jpg",1,1)
        val attachment2 = VideoAttachment("video", "https://example.com/image.jpg","link",1,1)
        val attachment3 = DocumentAttachment("doc", "https://example.com/video.mp4", "link")
        // assertEquals(attachment1.hashCode(), attachment2.hashCode())
        assertNotEquals(attachment1.hashCode(), attachment3.hashCode())
    }
}