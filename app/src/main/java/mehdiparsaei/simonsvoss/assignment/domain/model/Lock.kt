package mehdiparsaei.simonsvoss.assignment.domain.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "locks",
    foreignKeys = [
        ForeignKey(
            entity = Building::class,
            parentColumns = ["id"],
            childColumns = ["buildingId"],
            onDelete = CASCADE
        ),
    ],
)
data class Lock(
    @PrimaryKey
    val id: String,
    val buildingId: String,
    @ColumnInfo(defaultValue = "")
    val description: String = "",
    @ColumnInfo(defaultValue = "Undefined")
    val floor: String,
    val shortCut: String? = null,
    val name: String,
    val roomNumber: String,
    val serialNumber: String,
    val type: String
)