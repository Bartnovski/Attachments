class Page(
    val id: Int,
    val groupId: Int,
    val creatorId: Int,
    val title: String,
    val currentUserCanEdit: Boolean,
    val currentUserCanEditAccess: Boolean,
    whoCanView: Int,
    whoCanEdit: Int,
    val edited: Int,
    val created: Int,
    val editorId: Int,
    val views: Int,
    val parent: String,
    val parent2: String,
    val source: String,
    val html: String,
    val viewUrl: String
) {
    var whoCanView = when (whoCanView) {
        1, 2 -> whoCanView
        else -> 0
    }

    var whoCanEdit = when (whoCanEdit) {
        1,2 -> whoCanEdit
        else -> 0
    }
}
