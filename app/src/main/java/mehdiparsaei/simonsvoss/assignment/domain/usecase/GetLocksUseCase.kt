package mehdiparsaei.simonsvoss.assignment.domain.usecase

import kotlinx.coroutines.flow.Flow
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock

interface GetLocksUseCase {
    operator fun invoke(searchQuery: String): Flow<Lock>
}