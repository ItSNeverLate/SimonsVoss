package mehdiparsaei.simonsvoss.assignment.domain.repository

import kotlinx.coroutines.flow.Flow
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock
import mehdiparsaei.simonsvoss.assignment.domain.util.Resource

interface LockRepository {
    fun getAll(searchQuery: String): Flow<Resource<List<Lock>>>
}