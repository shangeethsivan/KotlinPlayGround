import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

fun main() {

    val flow: Flow<Int> = flow {
        listOf(1, 2, 3).forEach {
            println("Emitting $it")
            emit(it)
            println("Someone Collected")
        }
    }

    val flow2: Flow<Int> = flow {
        listOf(1, 2, 3).forEach {
            println("Emitting $it")
            emit(it)
            println("Someone Collected")
        }
    }

    GlobalScope.launch {
        println(flow.map {
            val a = "collecting $it"
            println()
            a
        }.toList())


        flow2.collect {
            println(it)
        }
    }

    Thread.sleep(2000)

}
