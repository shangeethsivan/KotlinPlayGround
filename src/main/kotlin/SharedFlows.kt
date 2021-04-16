import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun main() {
    val scope = GlobalScope


//    val shareFlow: SharedFlow<Int> = flow {
//        println("Shared Flow printed ${b++}")
//        (1..500).forEach {
//            emit(it)
//            println("Shared Flow emitted $it")
//
//        }
//    }.shareIn(scope, SharingStarted.WhileSubscribed(1000), 2)


    val shareFlow = MutableSharedFlow<Int>(2, 10, BufferOverflow.SUSPEND)

    scope.launch {
        delay(1000)
        (1..500).forEach {
            shareFlow.emit(it)
            println(" Shared flow emitted: $it")
        }
    }

    scope.launch {
        shareFlow.collect {
            println("colecting shared flow in first scope ${System.currentTimeMillis()}: $it")
        }
    }


    scope.launch {
        shareFlow.collect {
            delay(2000)
            println("colecting shared flow in second scope ${System.currentTimeMillis()}: $it")
        }
    }

/*

        async {
            shareFlow.collect {
                println("colecting shared flow in second scope.. ${System.currentTimeMillis()}: $it")
            }
        }


        async {
            flow.collect {
                println("normal flow1 collecting $it")
            }
        }

        async {
            flow.collect {
                println("normal flow2 collecting $it")
            }
        }

        async {

            delay(1000)
            flow.collect {
                println("normal flow 3collecting $it")
            }
        }

        shareFlow.collect {
            println("colecting shared flow in second scope.. ${System.currentTimeMillis()}: $it")
        }
*/



    Thread.sleep(30000)
}