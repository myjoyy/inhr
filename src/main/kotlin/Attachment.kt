import attachments.Document
import attachments.Link
import attachments.Photo
import attachments.Video

sealed interface Attachment {
    val type: String
}

data class VideoAttachment(
    override val type: String = "video",
    val video: Video
) : Attachment



data class DocumentAttachment(
    override val type: String = "doc",
    val document: Document
) : Attachment

data class LinkAttachment(
    override val type: String = "link",
    val link: Link
) : Attachment



data class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo
) : Attachment

