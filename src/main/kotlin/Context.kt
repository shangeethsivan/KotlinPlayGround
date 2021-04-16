import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(context = CoroutineName("My Coroutine")) {
            println("This is running in ${this.coroutineContext[CoroutineName.Key]}")
        }
        GlobalScope.launch {
            println("This is running in --  ${this.coroutineContext}")
        }
    }
}