package mehdiparsaei.simonsvoss.assignment.domain.usecase

import kotlinx.coroutines.flow.Flow
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock
import mehdiparsaei.simonsvoss.assignment.domain.util.Resource

interface GetLocksUseCase {
    operator fun invoke(searchQuery: String): Flow<Resource<List<Lock>>>
}