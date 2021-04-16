import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
fun main() {

    val stateFlow = MutableStateFlow(0)

    val stateFlow2 = MutableStateFlow(0)

    val coroutineScope = GlobalScope
    coroutineScope.launch {
        delay(1000)
        for (i in 1..10) {
            stateFlow.value = i
            println("Emitted Value in flow 1 $i")
        }

    }

    coroutineScope.launch {
        delay(1000)
        for (i in 1..10) {
            stateFlow2.value = i
            println("Emitted Value in flow 2 $i")
        }

    }

    coroutineScope.launch {
        stateFlow.combine(stateFlow2) { i, j ->
            i * j
        }.collect {
            println("Collected $it")
        }
    }

    Thread.sleep(20000)
}