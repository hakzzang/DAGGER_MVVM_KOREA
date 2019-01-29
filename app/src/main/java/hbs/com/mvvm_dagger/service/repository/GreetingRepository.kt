package hbs.com.mvvm_dagger.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GreetingRepository : GreetingRepositoryContract{
    override fun greet(): String {
        return "hello"
    }

}