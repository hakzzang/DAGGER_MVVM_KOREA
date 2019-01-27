package hbs.com.mvvm_dagger.service.repository

class GreetingRepository : GreetingRepositoryContract{
    override fun greet(): String {
        return "hi!"
    }
}