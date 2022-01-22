package mehdiparsaei.simonsvoss.assignment.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "locks")
data class Lock(
    @PrimaryKey
    val id: String,
    val buildingId: String,
    @ColumnInfo(defaultValue = "")
    val description: String = "",
    @ColumnInfo(defaultValue = "Undefined")
    val floor: String,
    val name: String,
    val roomNumber: String,
    val serialNumber: String,
    val type: String
){
    @Ignore
    val buildingShortCut: String? = null
}