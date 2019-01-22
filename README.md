# DAGGER_MVVM_KOREA
Dagegr2와 Mvvm 패턴 연습장

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
