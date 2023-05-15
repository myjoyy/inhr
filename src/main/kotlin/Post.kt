data class Post(
        val ownerId: Long,
        val fromId: Long,
        val createdBy: Long,
        val attachments: Array<Attachment>,
        val original: Boolean,
        val text: String,
        val friendsOnly: Boolean,
        val likes: Int,
        val reposts: Int,
        val postType: String,
        val canPin: Boolean,
        val canDelete: Boolean,
        val canEdit: Boolean,
        val isPinned: Boolean,
        val isFavorite: Boolean,
        val id: Int,
        var comments: Array<Any>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (createdBy != other.createdBy) return false
        if (!attachments.contentEquals(other.attachments)) return false
        if (original != other.original) return false
        if (text != other.text) return false
        if (friendsOnly != other.friendsOnly) return false
        if (likes != other.likes) return false
        if (reposts != other.reposts) return false
        if (postType != other.postType) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (isFavorite != other.isFavorite) return false
        if (id != other.id) return false
        return true
    }
}


