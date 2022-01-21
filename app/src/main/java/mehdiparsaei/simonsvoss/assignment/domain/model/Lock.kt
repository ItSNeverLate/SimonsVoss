package mehdiparsaei.simonsvoss.assignment.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locks")
data class Lock(
    @PrimaryKey
    val id: String,
    val buildingId: String,
    val buildingShortCut: String?,
    val description: String?,
    val floor: String,
    val name: String,
    val roomNumber: String,
    val serialNumber: String,
    val type: String
)