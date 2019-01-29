package hbs.com.mvvm_dagger.viewmodel

import androidx.lifecycle.MutableLiveData
import hbs.com.mvvm_dagger.service.repository.GreetingRepositoryContract
import hbs.com.mvvm_dagger.viewmodel.MainViewModelContract
import javax.inject.Inject

class MainViewModel @Inject constructor(private val greetingRepository: GreetingRepositoryContract):
    MainViewModelContract {
    private var countLiveData:MutableLiveData<Int> = MutableLiveData()
    init{
        countLiveData.value = 0
    }

    override fun greet(): String{
        return greetingRepository.greet()
    }

    fun getData(): MutableLiveData<Int> {
        return countLiveData
    }
}