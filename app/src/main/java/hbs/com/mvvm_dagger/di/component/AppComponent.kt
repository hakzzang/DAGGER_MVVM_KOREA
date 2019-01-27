package hbs.com.mvvm_dagger.di.component

import androidx.appcompat.app.AppCompatActivity
import dagger.Component
import hbs.com.mvvm_dagger.di.module.RepositoryModule
import hbs.com.mvvm_dagger.di.module.ViewModelModule
import hbs.com.mvvm_dagger.ui.main.MainActivity
import hbs.com.mvvm_dagger.ui.main.sub.SubMainActivity

@Component(modules = [ViewModelModule::class, RepositoryModule::class])
interface AppComponent{
    fun inject(activity: MainActivity)
    fun inject(activity: SubMainActivity)
}