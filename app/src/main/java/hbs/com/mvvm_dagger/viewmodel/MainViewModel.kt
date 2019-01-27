package hbs.com.mvvm_dagger.viewmodel

import hbs.com.mvvm_dagger.service.repository.GreetingRepository
import hbs.com.mvvm_dagger.service.repository.GreetingRepositoryContract
import javax.inject.Inject

class MainViewModel @Inject constructor(private val greetingRepository: GreetingRepositoryContract): MainViewModelContract{
    override fun greet(): String{
        return greetingRepository.greet()
    }
}