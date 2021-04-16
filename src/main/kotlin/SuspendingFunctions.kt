import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

var functionCalls = 0
fun main() {
    val a = GlobalScope.launch {
        test()
        cool()
        test()
//
//        val job2 = launch {
//            println("println job started")
//            test()
//        }
    }

    a.invokeOnCompletion {
        println("${it?.message}")
    }

//    a.cancel()

    println("test")
    Thread.sleep(2100)

    println("there have been $functionCalls functions calls made")
}

suspend fun test() {
    println("** test started")
    delay(500)
    println("printing after 500 delay")
    functionCalls++
}

suspend fun cool() {
    delay(1000)
    println("Suspending functions are cool")
    functionCalls++
}