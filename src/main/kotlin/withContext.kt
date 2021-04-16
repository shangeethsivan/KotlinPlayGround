import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun main() {
    // with context - used to switch b/w dispatchers
    GlobalScope.launch(Dispatchers.IO) {
        println("Context $coroutineContext")
        withContext(Dispatchers.Unconfined) {
            println("Context $coroutineContext")
        }
        println("Context $coroutineContext")
    }
    Thread.sleep(2000)
}