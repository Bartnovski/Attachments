abstract class Attachments {
    open val type: String = ""
}
data class PhotoAttachment(
    val photo: Photo
): Attachments() {
    override val type = "photo"
}
 data class AudioAttachment(
    val audio: Audio
 ) : Attachments() {
     override val type = "audio"
 }
data class NoteAttachment(
    val note: Note
) : Attachments() {
    override val type = "note"
}
data class PageAttachment(
    val page: Page
) : Attachments() {
    override val type = "page"
}
data class LinkAttachment(
    val link: Link
) : Attachments() {
    override val type = "link"
}

class Product
class Button


