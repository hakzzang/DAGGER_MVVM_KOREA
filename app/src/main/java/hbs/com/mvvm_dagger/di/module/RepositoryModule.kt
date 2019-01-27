package hbs.com.mvvm_dagger.di.module

import dagger.Module
import dagger.Provides
import hbs.com.mvvm_dagger.service.repository.GreetingRepository
import hbs.com.mvvm_dagger.service.repository.GreetingRepositoryContract

@Module
class RepositoryModule{
    @Provides
    fun provideGreetingRepository() : GreetingRepositoryContract{
        return GreetingRepository()
    }
}