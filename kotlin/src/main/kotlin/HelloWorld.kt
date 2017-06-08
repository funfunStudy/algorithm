import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val cases = sc.nextInt()

    for (i in 0..cases - 1) {
        val name = sc.next()
        println("Hello, $name!")
    }
}

