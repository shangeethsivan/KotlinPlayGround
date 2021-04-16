import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    var a = 0;
    val flow = flow {
        a++
        (1..5000).forEach {
            println("Emitting value $it, flow initiated count $a")
            emit(it)
        }
    }

    GlobalScope.launch {
        flow.collect {
            println("flow builder colecting item : $it")
        }
    }

    GlobalScope.launch {
        delay(1000)
        flow.collect {
            println("flow builder delayed collector  : $it")
            delay(1000)
        }
    }

    runBlocking { delay(5000) }
}