fun main() {

    functionA {
        println("abc called")
    }

    println("test")

}

inline fun functionA(abc: () -> Unit) {
    abc()
    println("Function A ended")
}