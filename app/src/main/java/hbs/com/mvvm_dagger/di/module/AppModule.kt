package hbs.com.mvvm_dagger.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import hbs.com.mvvm_dagger.MyAndroidApplicationClass
import javax.inject.Singleton

@Module
public class AppModule(val app:MyAndroidApplicationClass){
    @Singleton
    @Provides
    fun provideContext(): Context {
        return this@AppModule.app
    }
}