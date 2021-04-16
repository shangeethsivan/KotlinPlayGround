import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        delayedPrint("Test 1", 3000)
        launch {
            delayedPrint("Test 2", 3000)
        }
    }

    Thread.sleep(4000)

}