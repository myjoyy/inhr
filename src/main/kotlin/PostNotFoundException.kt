class PostNotFoundException(s: String) : Throwable(s) {
    val s = "Post not found"
}
