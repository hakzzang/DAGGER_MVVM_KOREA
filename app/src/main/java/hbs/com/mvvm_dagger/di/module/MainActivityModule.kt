package hbs.com.mvvm_dagger.di.module

import dagger.Module
import dagger.Provides
import hbs.com.mvvm_dagger.MainActivityViewModel

@Module
class MainActivityModule{
    @Provides
    fun provideViewModel() = MainActivityViewModel() }