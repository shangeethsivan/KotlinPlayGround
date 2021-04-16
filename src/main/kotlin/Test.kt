fun main() {
    /*runBlocking {
        println("Test RB")
    }
    GlobalScope.launch(Dispatchers.IO) {
        println("Test")
    }
    println("hello")*/
//
//    val arr = arrayOf('a', 'b', 'c').toMutableList()
//
//
//    arr.forEach {
//        if (it == 'b') {
//            arr.add('c')
//        }
//    }
//
//    println(arr)


    val mutableList = mutableListOf(1, 2, 3)

    mutableList[1] = 10

    println(mutableList)
}