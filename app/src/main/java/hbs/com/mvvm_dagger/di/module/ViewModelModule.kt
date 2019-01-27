package hbs.com.mvvm_dagger.di.module

import dagger.Module
import dagger.Provides
import hbs.com.mvvm_dagger.service.repository.GreetingRepository
import hbs.com.mvvm_dagger.service.repository.GreetingRepositoryContract
import hbs.com.mvvm_dagger.viewmodel.MainViewModel

@Module
class ViewModelModule{
    @Provides
    fun provideMainViewModel(greetingRepository: GreetingRepositoryContract) : MainViewModel {
        return MainViewModel(greetingRepository)
    }
}