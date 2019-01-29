package hbs.com.mvvm_dagger.di.module

import hbs.com.mvvm_dagger.service.repository.GreetingRepository
import hbs.com.mvvm_dagger.viewmodel.GreetingViewModel
<<<<<<< HEAD
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module{
    single("greetRepos"){GreetingRepository()}
    viewModel{ GreetingViewModel(get("greetRepos")) }
=======
import org.koin.dsl.module.module

val appModule = module{
    single{GreetingRepository()}
    factory{ GreetingViewModel(get(),get()) }
>>>>>>> origin/master
}