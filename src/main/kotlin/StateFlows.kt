import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
fun main() {


    val stateFlow = MutableStateFlow(0)

    val coroutineScope = GlobalScope
    coroutineScope.launch {
        delay(2000)
        stateFlow.value = 1

        delay(2000)
        stateFlow.value = 1

        delay(2000)
        stateFlow.value = 3
    }

    //emit -> {0,1,2,3} c1 -> {0,1,2,3} c2 -> {0,1,2,3} c3 -> {1,2,3}

    //emit -> {0,1,0,3} c1 -> {0,1,0,3} c2 -> {0,1,0,3} c3 -> {1,0,3}

    //emit -> {0,0,3} c1 -> {0,3} c2 -> {0,3} c3 -> {0,3}

    coroutineScope.launch {
        stateFlow.collect {
            println("Collected in 1 $it")
        }
    }

    coroutineScope.launch {
        stateFlow.collect {
            println("Collected in 2 $it")
        }
    }


    coroutineScope.launch {
        delay(3000)
        stateFlow.collect {
            println("Collected in 3 $it")
        }
    }


    Thread.sleep(10000)
}