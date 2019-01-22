package hbs.com.mvvm_dagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import hbs.com.mvvm_dagger.MyAndroidApplicationClass.Companion.SUPER_DATA

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myApplication = application as MyAndroidApplicationClass
        myApplication.sureData()
        Log.d("",SUPER_DATA.toString())
    }
}
