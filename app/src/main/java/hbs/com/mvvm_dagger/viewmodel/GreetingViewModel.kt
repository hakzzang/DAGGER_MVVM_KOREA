package hbs.com.mvvm_dagger.viewmodel

import hbs.com.mvvm_dagger.service.repository.GreetingRepository

interface GreetingViewModelContract{
    fun sayHello():String
}

class GreetingViewModel(val greetingRepository: GreetingRepository, val greetingRepository2: GreetingRepository) : GreetingViewModelContract{
    override fun sayHello():String {
        return greetingRepository.greet()
    }
}

