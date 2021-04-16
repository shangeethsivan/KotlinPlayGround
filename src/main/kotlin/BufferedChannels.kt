import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    val channel = Channel<Int>(2)

    GlobalScope.launch {
        delay(500)
        for (it in channel){
            println("                       C2 received- ${System.currentTimeMillis()} $it")
            delay(1000)
            println("                       C2 received after delay- $it")
        }
    }

    GlobalScope.launch() {
        listOf(0,1,2,3,4,5).forEach{
            println("c1 sending ${System.currentTimeMillis()} $it")
            channel.send(it)
            println("c1 sent ${System.currentTimeMillis()} $it")
        }

    }



    Thread.sleep(10000)

}
