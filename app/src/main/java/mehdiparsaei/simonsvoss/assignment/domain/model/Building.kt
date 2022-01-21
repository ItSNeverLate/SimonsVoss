package mehdiparsaei.simonsvoss.assignment.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buildings")
data class Building(
    @PrimaryKey
    val id: String,
    val description: String,
    val name: String,
    val shortCut: String
)