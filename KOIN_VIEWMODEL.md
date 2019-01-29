# koin view model


`koin`에서는 `AAC`의 `ViewModel`을 inject 하기 위해서 `factory` 외에도 `viewmodel`을 제공해줍니다.
우선 aac에서 viewmodel을 사용하는 이유는 많은 문서에서 말하길, 액티비티가 회전되면서 context를 유지하거나
혹은 액티비티에서 다중의 프레그먼트에서 해당 context의 정보를 유지하는 것이 힘들었다고 합니다.

그래서 안드로이드에서는 AAC를 통해서 ViewModel이라는 라이브러리를 제공해주기 시작했고.
ViewModel을 프레그먼트의 상단인 holderFregment라는 객체를 이용해서 모든 생명주기의 상위에 있다고 합니다.

이것을 통해서 생명주기가 유지되는 동안에는 해당 View의 정보(context)가 유지될 수 있고,
onClear() 라는 매소드를 통해서 생명주기가 종료될 때, 값을 정리할 수 있게 됩니다.

이러한 유니크한 특성을 갖고 있는 ViewModel을 koin에서 생명주기를 유지해주기 위해서,
viewModel{} 이라는 것을 통해서 유지시켜준다고 생각합니다.
```
//GreetingViewModel
class GreetingViewModel() : ViewModel()
{
...
}

//appModele
viewModel { GreetingViewModel(get("greetRepos")) }

//GreetingActivity
val greetViewModel:GreetingViewModel by viewModel()

```
으로 viewModel을 처리할 수 있게 됩니다. 이전에는 `factory`를 만들어서 처리했습니다.

factory{객체()} -> val 선언 : 객체 by inject() 구조에서 viewModel{myModel()} val myModel : 객체 by viewModel()
로 변경된 구조로 사용이 됩니다.
