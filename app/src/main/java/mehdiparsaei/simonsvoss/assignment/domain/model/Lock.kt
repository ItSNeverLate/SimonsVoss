package mehdiparsaei.simonsvoss.assignment.domain.model

data class Lock(
    val id: String,
    val buildingId: String,
    val description: String?,
    val floor: String,
    val name: String,
    val roomNumber: String,
    val serialNumber: String,
    val type: String
)