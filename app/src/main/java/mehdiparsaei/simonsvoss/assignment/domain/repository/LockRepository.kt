package mehdiparsaei.simonsvoss.assignment.domain.repository

import kotlinx.coroutines.flow.Flow
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock

interface LockRepository {
    fun getAll(searchQuery: String): Flow<Lock>
}