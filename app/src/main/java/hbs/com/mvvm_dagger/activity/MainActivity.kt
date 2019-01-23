package hbs.com.mvvm_dagger.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import hbs.com.mvvm_dagger.MyAndroidApplicationClass
import hbs.com.mvvm_dagger.MyAndroidApplicationClass.Companion.SUPER_DATA
import hbs.com.mvvm_dagger.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        val myApplication = application as MyAndroidApplicationClass
        myApplication.sureData()
        Log.d("",SUPER_DATA.toString())
    }
}
