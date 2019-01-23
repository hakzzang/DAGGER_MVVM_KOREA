package hbs.com.mvvm_dagger.di.module

import dagger.android.ContributesAndroidInjector
import hbs.com.mvvm_dagger.activity.MainActivity

abstract class ActivityBuilder{
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity() : MainActivity
}