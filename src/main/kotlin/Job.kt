import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


// invoke on completion will be called regardless of cancelling a job
fun main() {
    val job1 = GlobalScope.launch {
        println("launched coroutine")
        delay(3000)

        launch {
            println("Wont print job cancelled")
        }
        launch {
            println("Wont print job cancelled")
        }
    }

    job1.invokeOnCompletion {
        println("job 1 complted $it")
    }
    Thread.sleep(1000)
    job1.cancel()
    println("job1 cancelled and ")

    val job2 = GlobalScope.launch {
        delay(500L)
        println("job2 launched")
    }

    job2.invokeOnCompletion { println("job2 completed $it") }

    Thread.sleep(1000)
}