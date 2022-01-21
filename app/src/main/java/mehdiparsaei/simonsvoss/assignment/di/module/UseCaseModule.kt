package mehdiparsaei.simonsvoss.assignment.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mehdiparsaei.simonsvoss.assignment.domain.repository.LockRepository
import mehdiparsaei.simonsvoss.assignment.domain.usecase.GetLocksUseCase
import mehdiparsaei.simonsvoss.assignment.domain.usecase.GetLocksUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetLocksUseCase(lockRepository: LockRepository): GetLocksUseCase =
        GetLocksUseCaseImpl(lockRepository)
}