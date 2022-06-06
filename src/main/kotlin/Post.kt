data class Post (
    val id: UInt,
    val ownerId: UInt,
    val fromId: UInt,
    val createdBy: UInt,
    val date: UInt,
    val text: String,
    val replyOwnerId: UInt,
    val replyPostId: UInt,
    val friendsOnly: Boolean,
    val comments: Comments?,
    val copyright: Copyright?,
    val likes: Likes?,
    val reposts: Reposts?,
    val views: Views?,
    val signerId: UInt,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut?,
    val postponedId: UInt,
    ) {

    var postType = "post"
    set(value) = when(value) {
        "copy","reply","postpone","suggest" -> field = value
        else -> field = "post"
    }
    val attachments = emptyArray<Attachments>()

}
