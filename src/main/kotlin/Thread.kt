data class Thread(
    val count: Int,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
) {
    val items = emptyArray<Any>()
}
