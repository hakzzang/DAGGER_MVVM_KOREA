package hbs.com.mvvm_dagger

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import hbs.com.mvvm_dagger.di.component.AppComponent
import javax.inject.Inject

class MyAndroidApplicationClass : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    companion object {
        const val SUPER_DATA = 0
    }

    fun sureData() {

    }

    override fun onCreate() {
        super.onCreate()

    }
}