data class Note(
    val id: Int,
    var title: String,
    var text: String,
    val date: Int,
    val comments: MutableList<Comment> = mutableListOf(),
    val read_comments: Int,
    val view_url: String,
    val privacy_view: String,
    val can_comment: Int,
    val text_wiki: String
)