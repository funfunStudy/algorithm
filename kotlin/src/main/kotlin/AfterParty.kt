import java.util.Scanner

/**
 * Created by Lazysoul on 2017. 7. 18..
 */
object AfterParty {

    @JvmStatic
    fun main(args: Array<String>) {

        val sc = Scanner(System.`in`)

        val count = sc.nextLine()
                .split(" ")
                .map { it.toInt() }
                .reduce { acc, value -> acc * value }

        val result = sc.nextLine()
                .split(" ")
                .map { it.toInt() - count }

        require(result == listOf(-1, 1, 900, -100, -3))
    }
}