# KOIN_STUDY

3-0. 참고자료

https://kaidroid.me/post/dependency-injection-with-kotlin-koin/
https://proandroiddev.com/koin-in-feature-modules-project-6329f069f943

3-1. koin 입문

Dagger를 프로젝트에 바로 사용하기에는 런닝커브가 너무 높다고
판단하였고, koin을 사용하기로 결정했습니다. 그에 따라서
koin에 대해서 정리하고자 합니다.

기본적으로 사용하는 예약어는 `module`,`single`,`factory`,`get`,`inject` 등이 있습니다.
`module`은 해당 module을 정의하기 위해서 사용했습니다.
`single`은 해당 객체를 싱글톤으로 유지하고, 모든 인젝션에서 공유하기 위해서 사용했습니다.
`facotry`는 해당 inject 할 때, 해당 객체를 만들어서 유지하기 위해서 사용했습니다.
`get`은 `factory`나 `viewmodel`에서 appModule에서 `single`과 같이 만든 객체를 제공할 때 사용했습니다.
`inject`는 by inject() 형태로 activity에서 해당 모듈에 의존성을 주입합니다.

![image](https://user-images.githubusercontent.com/22374750/51916361-7e6ae980-2420-11e9-94f1-4fbb89039211.png)

3-2. GreetingApplication
startKoin을 하기 위해서 사용하는 BaseApplication 입니다.
```
class GreetingApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}
```

3-3. appModule
기존에 만들어진 GreetingRepository를 `single` 상태로 유지하고,
`factory`를 통해서 추후에 프로젝트에서 사용하는 객체를 provide 할 수 있게 합니다.
`get`을 통해서 `factory` 내부에서 사용하는 객체의 변수를 전달합니다.
```
val appModule = module{
    single("greetRepos"){GreetingRepository()}
    factory{ GreetingViewModel(get("greetRepos")) }
}
```

3-4. GreetingRepository
특정 데이터를 관리하는 Repository
```
class GreetingRepository : GreetingRepositoryContract{
    override fun greet(): String {
        return "hello"
    }
}
```

3-5. GreetingViewModel
ViewModel은 repository를 갖고 와서 
```
interface GreetingViewModelContract{
    fun sayHello():String
}

class GreetingViewModel(val greetingRepository: GreetingRepository) : ViewModel(), GreetingViewModelContract{
    override fun sayHello():String {
        return greetingRepository.greet()
    }
}
```
