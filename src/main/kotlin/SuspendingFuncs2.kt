import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// suspending function - functions that can be run in a coroutine


var fCalls = 0

fun main() {
    GlobalScope.launch { susp1() }
    GlobalScope.launch { susp2() }
    Thread.sleep(1500L)
    println("Function calls $fCalls")
}

suspend fun susp1() {
    delay(500L)
    println("Inside demo")
    fCalls++
}

suspend fun susp2(){
    delay(1000L)
    println("Inside susp2")
    fCalls++
}