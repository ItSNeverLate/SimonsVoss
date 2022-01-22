package mehdiparsaei.simonsvoss.assignment.data.repository

import androidx.room.withTransaction
import kotlinx.coroutines.flow.Flow
import mehdiparsaei.simonsvoss.assignment.data.local.AppDB
import mehdiparsaei.simonsvoss.assignment.data.remote.AppApi
import mehdiparsaei.simonsvoss.assignment.data.util.networkBoundResource
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock
import mehdiparsaei.simonsvoss.assignment.domain.repository.LockRepository
import mehdiparsaei.simonsvoss.assignment.domain.util.Resource
import java.lang.Exception

class LockRepositoryImpl(
    private val appApi: AppApi,
    private val appDB: AppDB,
) : LockRepository {
    override fun getAll(searchQuery: String): Flow<Resource<List<Lock>>> = networkBoundResource(
        query = {
            appDB.lockDao().getAll(searchQuery)
        },
        fetch = {
            appApi.getData()
        },
        saveFetchResult = { result ->
            appDB.withTransaction {
                val locks = result.locks
                appDB.lockDao().insertAll(locks)

                val buildings = result.buildings
                appDB.buildingDao().insertAll(buildings)
            }
        }
    )
}