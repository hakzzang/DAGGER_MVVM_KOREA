package hbs.com.mvvm_dagger.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import hbs.com.mvvm_dagger.BR
import hbs.com.mvvm_dagger.viewmodel.MainViewModel
import hbs.com.mvvm_dagger.R
import hbs.com.mvvm_dagger.databinding.ActivityMainBinding
import javax.inject.Inject

/*
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.component.inject(this)
        val mainActivityBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityBinding.setVariable(BR.mainViewModel, viewModel)
    }
}*/
