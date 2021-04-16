import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {

//        withContext(Dispatchers.Main) {
//            println(" Main - ${Thread.currentThread().name}")
//        }
        withContext(Dispatchers.Default) {
            println(" Default - ${Thread.currentThread().name}")
        }

        withContext(Dispatchers.IO) {
            println(" IO - ${Thread.currentThread().name}")
        }

        withContext(Dispatchers.Unconfined) {
            println(" Unc-1 - ${Thread.currentThread().name}")
            delay(1000L)
            println(" Unc-2 - ${Thread.currentThread().name}")
        }
    }
    Thread.sleep(1200L)
}