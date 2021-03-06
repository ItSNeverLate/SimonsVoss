package mehdiparsaei.simonsvoss.assignment.domain.usecase

import kotlinx.coroutines.flow.Flow
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock
import mehdiparsaei.simonsvoss.assignment.domain.repository.LockRepository
import mehdiparsaei.simonsvoss.assignment.domain.util.Resource

class GetLocksUseCaseImpl(private val lockRepository: LockRepository) : GetLocksUseCase {
    override fun invoke(searchQuery: String): Flow<Resource<List<Lock>>> {
        // Do some validation if it is needed
        return lockRepository.getAll(searchQuery)
    }
}