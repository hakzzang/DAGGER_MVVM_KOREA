package hbs.com.mvvm_dagger.di.component

import dagger.Component
import hbs.com.mvvm_dagger.di.module.RepositoryModule
import hbs.com.mvvm_dagger.di.module.ViewModelModule
import hbs.com.mvvm_dagger.ui.main.MainActivity

@Component(modules = [ViewModelModule::class, RepositoryModule::class])
interface AppComponent{
    fun inject(activity: MainActivity)
}