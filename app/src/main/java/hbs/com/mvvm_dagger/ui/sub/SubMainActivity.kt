package hbs.com.mvvm_dagger.ui.sub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import hbs.com.mvvm_dagger.BR
import hbs.com.mvvm_dagger.R
import hbs.com.mvvm_dagger.databinding.ActivitySubBinding
import hbs.com.mvvm_dagger.viewmodel.MainViewModel
import javax.inject.Inject

/*
class SubMainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.component.inject(this)
        val subActivityBinding: ActivitySubBinding = DataBindingUtil.setContentView(this, R.layout.activity_sub)
        subActivityBinding.setVariable(BR.greet, viewModel.greet())
    }
}*/
