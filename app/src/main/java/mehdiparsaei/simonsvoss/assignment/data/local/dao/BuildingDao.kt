package mehdiparsaei.simonsvoss.assignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import mehdiparsaei.simonsvoss.assignment.domain.model.Building

@Dao
interface BuildingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(buildings: List<Building>)
}
