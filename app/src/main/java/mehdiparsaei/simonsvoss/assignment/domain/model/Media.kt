package mehdiparsaei.simonsvoss.assignment.domain.model

data class Media(
    val id: String,
    val groupId: String,
    val owner: String,
    val type: String,
    val description: String?,
    val serialNumber: String,
)