fun main() {
    val lazy = Lazy()
    println(lazy.testLazy)
    println(lazy.testLazy)
}

class Lazy {

    val testLazy by lazy { test() }

    fun test(): String {
        println("test is called")
        return "testing "
    }
}