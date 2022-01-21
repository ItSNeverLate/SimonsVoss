package mehdiparsaei.simonsvoss.assignment.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mehdiparsaei.simonsvoss.assignment.data.local.AppDB
import mehdiparsaei.simonsvoss.assignment.data.remote.AppApi
import mehdiparsaei.simonsvoss.assignment.data.repository.LockRepositoryImpl
import mehdiparsaei.simonsvoss.assignment.domain.repository.LockRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLockRepository(api: AppApi, db: AppDB): LockRepository =
        LockRepositoryImpl(api, db)
}