import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    // async - used to return resutls from coroutines
    GlobalScope.launch {
        val def = async {
            println("start async")
            return@async "return value"
        }
        println("launched ")
        delay(1000)
        println(def.await())
    }

    Thread.sleep(2000)


    val list = listOf("test","test1")

    val array = intArrayOf(1, 2, 3)

    val array2 = arrayOf(*list.toTypedArray())

    test(*array)
}

fun test(vararg elements: Int){

}
