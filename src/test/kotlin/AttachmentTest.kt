
import attachments.Document
import attachments.Photo
import attachments.Video
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test



class AttachmentTest {

    @Test
    fun testToString() {
        val attachmentPhoto = Photo("image", "https://example.com/image.jpg",11, 599)
        assertEquals("Photo(type=image, url=https://example.com/image.jpg, width=11, height=599)", attachmentPhoto.toString())
    }

    @Test
    fun testEquals() {
        val photoAttach = attachments.Photo("image", "https://example.com/image.jpg", 1000, 1499)
        val videoAttach = attachments.Video("video", "Youtube", "https//&*/,com", 1080)
        val documentAttach = attachments.Document("doc", "Excel", "https//&*/,com", "csv")

        assertEquals(videoAttach, videoAttach)
        assertNotEquals(photoAttach, videoAttach)
        assertNotEquals(photoAttach, documentAttach)
    }

    @Test
    fun testHashCode() {
        val attachment1 = Photo( "image", "https://example.com/image.jpg", 599, 300)
        val attachment2 = Video("video", "https://example.com/image.jpg","link",1)
        val attachment3 = Document("doc", "https://example.com/video.mp4", "link","csv")
        assertNotEquals(attachment1.hashCode(), attachment2.hashCode())
        assertNotEquals(attachment1.hashCode(), attachment3.hashCode())
    }
}
class VideoAttachmentTest {
    @Test
    fun testVideoAttachment() {
        // create a video attachment
        val video = Video("video", "Youtube", "https//&*/,com", 1080)
        val videoAttachment = VideoAttachment(video = video)

        // check that the attachment has the correct type and video
        assertEquals("video", videoAttachment.type)
        assertEquals(video, videoAttachment.video)
    }
}

class DocumentAttachmentTest {
    @Test
    fun testDocumentAttachment() {
        // create a document attachment
        val document = Document("doc", "Document", "https://example.com/document.pdf", "pdf")
        val documentAttachment = DocumentAttachment(document = document)

        // check that the attachment has the correct type and document
        assertEquals("doc", documentAttachment.type)
        assertEquals(document, documentAttachment.document)
    }
}

class PhotoAttachmentTest {
    @Test
    fun testPhotoAttachment() {
        // create a photo attachment
        val photo = Photo("photo", "https://example.com/photo.jpg", 640, 480)
        val photoAttachment = PhotoAttachment(photo = photo)

        // check that the attachment has the correct type and photo
        assertEquals("photo", photoAttachment.type)
        assertEquals(photo, photoAttachment.photo)
    }
}

class LinkAttachmentTest {
    @Test
    fun testLinkAttachment() {
        // create a link attachment
        val link = attachments.Link("link", "Example Link", "example.com", "https://example.com")
        val linkAttachment = LinkAttachment(link = link)

        // check that the attachment has the correct type and link
        assertEquals("link", linkAttachment.type)
        assertEquals(link, linkAttachment.link)
    }

    @Test
    fun testLinkAttachmentWithType() {
        // create a link attachment with a custom type
        val link = attachments.Link("link", "Example Link", "example.com", "https://example.com")
        val linkAttachment = LinkAttachment(type = "custom", link = link)

        // check that the attachment has the correct type and link
        assertEquals("custom", linkAttachment.type)
        assertEquals(link, linkAttachment.link)
    }
}