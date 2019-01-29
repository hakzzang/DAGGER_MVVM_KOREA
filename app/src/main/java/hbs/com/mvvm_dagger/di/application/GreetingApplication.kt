package hbs.com.mvvm_dagger.di.application

import android.app.Application
import hbs.com.mvvm_dagger.di.module.appModule
import org.koin.android.ext.android.startKoin

class GreetingApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}