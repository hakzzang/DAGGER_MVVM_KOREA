package hbs.com.mvvm_dagger.di.application

import android.app.Application
import androidx.lifecycle.ViewModel
import hbs.com.mvvm_dagger.di.module.RepositoryModule
import hbs.com.mvvm_dagger.di.module.ViewModelModule

/*
class MyApplication : Application(){
    companion object {
        lateinit var component : AppComponent private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .viewModelModule(ViewModelModule())
            .repositoryModule(RepositoryModule())
            .build()
    }
}*/
