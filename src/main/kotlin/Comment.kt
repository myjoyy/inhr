data class Comment(
        val id: Int,
        var fromId: Int,
        val date: Int,
        var text: String,
        val donut: Any?,
        val replyToUser: Int?,
        val replyToComment: Int?,
        val attachments: Any?,
        val parentsStack: Int,
        val thread: Any?,
        val postId: Int,
        val likes: Int
                  )
