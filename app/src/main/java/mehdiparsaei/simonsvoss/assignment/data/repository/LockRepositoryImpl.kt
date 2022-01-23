package mehdiparsaei.simonsvoss.assignment.data.repository

import androidx.room.withTransaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import mehdiparsaei.simonsvoss.assignment.data.local.AppDB
import mehdiparsaei.simonsvoss.assignment.data.local.preferences.PreferencesManager
import mehdiparsaei.simonsvoss.assignment.data.remote.AppApi
import mehdiparsaei.simonsvoss.assignment.data.util.networkBoundResource
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock
import mehdiparsaei.simonsvoss.assignment.domain.repository.LockRepository
import mehdiparsaei.simonsvoss.assignment.domain.util.Resource
import java.util.*

class LockRepositoryImpl(
    private val appApi: AppApi,
    private val appDB: AppDB,
    private val appPreferencesManager: PreferencesManager,
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
                val buildings = result.buildings
                appDB.buildingDao().insertAll(buildings)

                val locks = result.locks
                appDB.lockDao().insertAll(locks)

                appPreferencesManager.setDataLastUpdate()
            }
        },
        shouldFetch = {
            // Database Refreshing policy
            // Locks list data refreshes once a day
            appPreferencesManager.dataLastUpdate.first() !=
                    Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        }
    )
}