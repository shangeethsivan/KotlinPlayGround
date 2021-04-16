import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun main() {

    val mutableSharedFlow = MutableSharedFlow<Int>(2, 2, onBufferOverflow = BufferOverflow.SUSPEND)

    val scope = GlobalScope
    scope.launch {
        delay(500)
        for (i in 10..20) {
            delay(1000)
            mutableSharedFlow.emit(i)
            println("Emitted Value: $i")
        }
    }

    scope.launch {
        mutableSharedFlow.collect {
            delay(1500)
            println("collect 0 $it")
        }
    }
    scope.launch {
        delay(30000)
        mutableSharedFlow.collect {
            println("collect 1 $it")
        }
    }
    scope.launch {
        delay(30000)
        mutableSharedFlow.collect {
            println("collect 2 $it")
        }
    }


    Thread.sleep(50000)
}