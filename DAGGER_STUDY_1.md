# 스터디 자료 1
## 대거 시작

Dagger를 사용하기 이전에 안드로이드에 관련된 개념이 튼튼해야 합니다.
`Annotaion` , `Application`에 대해서 먼저 알려드리겠습니다.

Annotation은 Java에서 사용하는 메타데이터의 일종입니다.
Application 클래스는 Android의 4대 컴포넌트에서 공유하고 있는 일종의
클래스이며, onCreate, onTrimMemory, onLowMemory, onTermate 등을 오버라이드하여 사용할 수 있습니다.

```
apply plugin: 'kotlin-kapt'

dependencies {

    def daggerVer = "2.21"
    implementation "com.google.dagger:dagger-android:$daggerVer"
    implementation "com.google.dagger:dagger-android-support:$daggerVer" // if you use the support libraries
    kapt "com.google.dagger:dagger-android-processor:$daggerVer"
    kapt "com.google.dagger:dagger-compiler:$daggerVer"
}
```

0. 참고자료
https://qiita.com/sudachi808/items/a05237e1294639ea41dd

1. simple dagger2 + kotlin + viewModel
![image](https://user-images.githubusercontent.com/22374750/51797558-2a59dc80-2249-11e9-983c-ccedc83843bd.png)

1-1. MainViewModel
MainViewModel은 viewModel data입니다.
```
class MainViewModel(){
    fun greet(): String{
        return "hello"
    }
}
```

1-2. ViewModelModule

ViewModelModule은 MainViewModel을 만들어서 provide해주는 Module 객체입니다.
```
@Module
class ViewModelModule{
    @Provides
    fun provideMainViewModel() : MainViewModel{
        return MainViewModel()
    }
}
```

1-3. MainActivityComponent

MainActivityComponent는 module을 component에 집어넣습니다.
또한 inject 매소드는 Activity와 @Inject 객체를 이어주는 역할을 합니다.

```
@Component(modules = [ViewModelModule::class])
interface MainActivityComponent{
    fun inject(activity: MainActivity)
}
```

1-4. MainActivity

MainActivity에서는 Component 인터페이스 앞에 Dagger라는 이름이 붙은 클래스가 자동으로 만들어지는데
해당 클래스를 통해서 interface 안에 modules의 값들에 Module을 매칭시켜줘서
component를 만들게 되고, 해당 component는 inject시켜서 @Inject라는 메타태그가 있는 변수에
자동적으로 값을 넣어주게 됩니다.
```
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel
    private val component = DaggerMainActivityComponent.builder()
        .viewModelModule(ViewModelModule())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)
        tv_test.text = viewModel.greet()
    }
}
```
