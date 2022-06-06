data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut?,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Attachments?,
    val thread: Thread?
){
    val parentsArray = emptyArray<Int>()

    data class Donut(
        val isDon: Boolean,
        val placeholder: String
    )
}
