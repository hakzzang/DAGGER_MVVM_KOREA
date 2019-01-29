package hbs.com.mvvm_dagger.viewmodel

import androidx.lifecycle.ViewModel
import hbs.com.mvvm_dagger.service.repository.GreetingRepository

interface GreetingViewModelContract{
    fun sayHello():String
}

class GreetingViewModel(val greetingRepository: GreetingRepository) :
    ViewModel(), GreetingViewModelContract{
    override fun sayHello():String {
        return greetingRepository.greet()
    }
}

