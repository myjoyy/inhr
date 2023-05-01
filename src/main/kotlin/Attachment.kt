sealed interface Attachment {
    val type: String
}

data class AudioAttachment(
    override val type: String = "audio",
    val artist: String,
    val title: String,
    val url: String
) : Attachment

data class DocumentAttachment(
    override val type: String = "doc",
    val title: String,
    val url: String
) : Attachment

data class LinkAttachment(
    override val type: String = "link",
    val title: String,
    val url: String
) : Attachment

data class PhotoAttachment(
    override val type: String = "photo",
    val url: String,
    val width: Int,
    val height: Int
) : Attachment

data class VideoAttachment(
    override val type: String = "video",
    val title: String,
    val url: String,
    val width: Int,
    val height: Int
) : Attachment

// Для примера

val audioAttachment = Audio("audio", "Artist", "Title", "https://example.com/audio.mp3")
val documentAttachment = Document("doc", "Document", "https://example.com/document.pdf")
val linkAttachment = Link("link", "Link", "https://example.com")
val photoAttachment = Photo("photo", "https://example.com/photo.jpg", 800, 600)
val videoAttachment = Video("video", "Video", "https://example.com/video.mp4", 1280, 720)