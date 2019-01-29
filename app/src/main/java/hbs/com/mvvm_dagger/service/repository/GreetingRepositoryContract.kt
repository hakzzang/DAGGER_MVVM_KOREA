package hbs.com.mvvm_dagger.service.repository

import androidx.lifecycle.LiveData

interface GreetingRepositoryContract{
    fun greet() : String
}