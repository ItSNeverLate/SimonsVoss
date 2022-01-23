package mehdiparsaei.simonsvoss.assignment.data.local.dao

import androidx.room.*
import mehdiparsaei.simonsvoss.assignment.domain.model.Building

@Dao
interface BuildingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(buildings: List<Building>)

    @Query("DELETE FROM buildings")
    suspend fun deleteAll()
}
