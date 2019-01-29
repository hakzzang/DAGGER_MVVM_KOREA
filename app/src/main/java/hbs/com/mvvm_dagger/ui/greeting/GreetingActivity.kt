package hbs.com.mvvm_dagger.ui.greeting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hbs.com.mvvm_dagger.R
import hbs.com.mvvm_dagger.viewmodel.GreetingViewModel
import kotlinx.android.synthetic.main.activity_greeting.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class GreetingActivity : AppCompatActivity() {
    val greetViewModel:GreetingViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)
        tv_test.text = greetViewModel.sayHello() +"data"
    }
}