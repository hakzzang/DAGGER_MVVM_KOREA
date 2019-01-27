package hbs.com.mvvm_dagger.ui.main.sub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hbs.com.mvvm_dagger.R
import hbs.com.mvvm_dagger.di.application.MyApplication
import hbs.com.mvvm_dagger.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class SubMainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.component.inject(this)
        tv_test.text = "sub"+viewModel.greet()
    }
}