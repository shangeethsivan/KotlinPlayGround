import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
fun main() {
/*
    val channel = Channel<Int>()

    GlobalScope.launch {
        for (it in channel){
            println("C1- $it")
        }
    }

    GlobalScope.launch {
        for (it in channel){
            println("C2- $it")
        }
    }

    GlobalScope.launch {
        listOf(1,2,3,4).forEach{
            channel.send(it)
        }
    }

    Thread.sleep(4000)*/


    val basket = ConflatedBroadcastChannel<String>()

    GlobalScope.launch { // coroutine1
        val fruits = listOf("Apple", "Orange", "Banana")
        for (fruit in fruits) {
            basket.send(fruit)
            println("coroutine1: sent $fruit")
        }
    }


    GlobalScope.launch { // coroutine2
        repeat(1) {
            delay(500)
            println("coroutine3: Received ${basket.value}")
        }
    }


    GlobalScope.launch { // coroutine2
        repeat(1) {
            delay(500)
            println("coroutine2: Received ${basket.value}")
        }
    }

    Thread.sleep(5000)
}
