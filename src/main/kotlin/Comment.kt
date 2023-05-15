data class Comment(
        val id: Int,
        val fromId: Int,
        val date: Int,
        val text: String,
        val donut: Any?,
        val replyToUser: Int?,
        val replyToComment: Int?,
        val attachments: Any?,
        val parentsStack: Array<Any>?,
        val thread: Any?
)
