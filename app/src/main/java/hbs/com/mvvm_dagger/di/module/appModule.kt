package hbs.com.mvvm_dagger.di.module

import hbs.com.mvvm_dagger.service.repository.GreetingRepository
import hbs.com.mvvm_dagger.viewmodel.GreetingViewModel
import org.koin.dsl.module.module

val appModule = module{
    single{GreetingRepository()}
    factory{ GreetingViewModel(get(),get()) }
}