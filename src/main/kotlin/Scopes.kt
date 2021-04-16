import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch {
            delay(1000)
            // this will print second
            println("Run blocking scope ${Thread.currentThread().name}")
        }
        GlobalScope.launch() {
            delay(3000)
            // This will print first
            println("Global scope ${Thread.currentThread().name}")
        }
        coroutineScope {
            launch {
                delay(3000)
                // this will print third
                println("Coroutine scope ${Thread.currentThread().name}")
            }
        }
    }
    println("program ends")
}