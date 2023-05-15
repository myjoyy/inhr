object WallService {
    var posts = emptyArray<Post>()
    private var nextId = 1
    private var comments = emptyArray<Comment>()
    fun createComment(postId: Int, comment: Comment): Comment {
        val post = posts.find { it.id == postId } ?: throw PostNotFoundException("ID $postId")
        val newComment = comment.copy(id = comments.size + 1, fromId = postId)
        comments += newComment
        post.comments += newComment
        return newComment
    }

    fun clear() {
        posts = emptyArray()
        val post = Post(
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            text = "",
            likes = 0,
            reposts = 0,
            postType = "",
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            isFavorite = false,
            id = 0,
            comments = emptyArray(),
            attachments = emptyArray(),
            original = true,
            friendsOnly = false
        )
    }

    fun add(post: Post): Post {
        posts += post.copy(id = nextId++)
        return posts.last()

    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
                return true
            }
        }
        return false
    }


    fun printAll() {
        for (post in posts) {
            println(post)
        }
    }

    fun getPostComments(postId: Int): Any? {
        return posts.find { it.id == postId }
    }


}