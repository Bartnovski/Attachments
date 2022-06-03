class Donut(
    val isDonut: Boolean,
    val paidDuration: UInt,
    val placeholder: Placeholder,
    val canPublishFreeCopy: Boolean,
    editMode: String
) {
    val editMode = when(editMode) {
        "all" -> editMode
        else -> "duration"
    }
}


