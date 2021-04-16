import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
fun main() {

    //Default
    GlobalScope.launch {
        delayedPrint("Default ${Thread.currentThread().name}")
    }
    // lazy
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delayedPrint("lazy print ${Thread.currentThread().name}")
    }


    //Atomic
    GlobalScope.launch(start = CoroutineStart.ATOMIC) {
        delayedPrint("Atomic print ${Thread.currentThread().name}")
    }


    //Atomic
    GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
        delayedPrint("Undispatched print ${Thread.currentThread().name}")
        delayedPrint("Undispatched print ${Thread.currentThread().name}")
        delayedPrint("Undispatched print ${Thread.currentThread().name}")
    }

    println("${job.isCompleted}")

    job.start()
    Thread.sleep(6000)
}

suspend fun delayedPrint(string: String, timeInMs: Long = 1000) {
    delay(timeInMs)
    println(string)
}