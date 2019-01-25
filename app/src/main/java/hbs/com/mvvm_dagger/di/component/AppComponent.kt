package hbs.com.mvvm_dagger.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import hbs.com.mvvm_dagger.di.module.ActivityBuilder
import hbs.com.mvvm_dagger.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, AppModule::class , ActivityBuilder::class))
interface AppComponent{
    @Component.Builder
    interface Builder{
        @BindsInstance fun application(app:Application) : Builder
        fun build() : AppComponent
    }

    fun inject(app: Application)
}