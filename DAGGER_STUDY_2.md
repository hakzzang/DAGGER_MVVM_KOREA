
# 2. simple dagger + mvvm + repository + viewModel

![image](https://user-images.githubusercontent.com/22374750/51800886-d3b8c680-2279-11e9-8e4c-0f0102816057.png)

2-1. MainViewModel

MainViewModel에서는 생성자 앞 부분에 @Inject 어노테이션이 붙어있는 것을 확인할 수 있습니다.
GreetingRepository 또한 객체로 생성될텐데, 이것을 inject 하기 위해서 사용하는 것이라고 생각합니다.
```
class MainViewModel @Inject constructor(private val greetingRepository: GreetingRepositoryContract): MainViewModelContract{
    override fun greet(): String{
        return greetingRepository.greet()
    }
}
```
2-2. MainViewModelContract

단순 인터페이스 객체입니다.
```
interface MainViewModelContract{
    fun greet():String
}
```
2-3. GreetingRepository

Repository는 객체를 불러오는 로직을 의미합니다.
```
class GreetingRepository : GreetingRepositoryContract{
    override fun greet(): String {
        return "hi!"
    }
}
```

2-4. GreetingRepositoryContract

단순 인터페이스입니다.
```
interface GreetingRepositoryContract{
    fun greet() : String
}
```

2-5. ViewModelModule

ViewModelModule은 greetingRepository객체를 받아서 전달합니다.
MainViewModel에서는 해당 받은 객체를 바로 inject합니다.
```
@Module
class ViewModelModule{
    @Provides
    fun provideMainViewModel(greetingRepository: GreetingRepositoryContract) : MainViewModel {
        return MainViewModel(greetingRepository)
    }
}
```

2-6. RepositoryModule

RepositoryModule은 GreetingRepository객체를 만들어서 전달합니다.
```
@Module
class RepositoryModule{
    @Provides
    fun provideGreetingRepository() : GreetingRepositoryContract{
        return GreetingRepository()
    }
}
```

2-7. AppComponent

AppComponent에서 각종 모듈을 관리하고,
inject를 각종 Activity와 매칭합니다.
```
@Component(modules = [ViewModelModule::class, RepositoryModule::class])
interface AppComponent{
    fun inject(activity: MainActivity)
    fun inject(activity: SubMainActivity)
}
```

2-8. MyApplication

Application은 4대컴포넌트가 데이터를 공유할 수 있도록 만들어진 클래스입니다.
그렇기 때문에 해당 컴포넌트들의 라이프사이클보다 먼저 만들어지고,
onCreate부분에서 AppComponent를 만드는 역할을 합니다.
`private set`은 해당 클래스에서만 변수의 값을 변환하고,
다른 곳에서는 변환할 수 없게 하기 위해서 사용합니다.
해당 클래스를 통해 액티비티에서 MyApplication.component.inject(this) 를 통해서
di를 제공합니다.
class MyApplication : Application(){
    companion object {
        lateinit var component : AppComponent private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .viewModelModule(ViewModelModule())
            .repositoryModule(RepositoryModule())
            .build()
    }
}

2-9. MainActivity & SubActivity

Activity 단에서는 컴포넌트를 호출해 `inject`를 해줍니다.
```
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.component.inject(this)
        tv_test.text = viewModel.greet()
    }
}
```
