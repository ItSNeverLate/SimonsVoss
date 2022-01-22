package mehdiparsaei.simonsvoss.assignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock

@Dao
interface LockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(locks: List<Lock>)

    @Query("SELECT locks.*, buildings.shortCut " +
            "FROM locks INNER JOIN buildings " +
            "ON locks.buildingId = buildings.id " +
            "WHERE locks.name LIKE '%' || :searchQuery ||'%' " +
            "OR locks.roomNumber LIKE '%' || :searchQuery ||'%' " +
            "OR locks.floor LIKE '%' || :searchQuery ||'%' " +
            "OR buildings.shortCut LIKE '%' || :searchQuery ||'%' " +
            "OR buildings.name LIKE '%' || :searchQuery ||'%'")
    fun getAll(searchQuery: String): Flow<List<Lock>>
}
