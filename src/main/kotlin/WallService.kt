object WallService {
    var posts = emptyArray<Post>()
    private var nextId = 1
    fun clear() {
        posts = emptyArray()
        val post = Post(id = 0, ownerId = 0, fromId = 0, createdBy = 0, text = "", reposts = 0, likes = 0, postType = "", canPin = true, canDelete = true, canEdit = true, isPinned = false, isFavorite = false)
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
}