import java.util.Scanner

/**
 * Created by Lazysoul on 2017. 7. 18..
 */
object DigitalRoot {

    @JvmStatic
    fun main(args: Array<String>) {

        val sc = Scanner(System.`in`)
        val result = getResult(sc, listOf())

        require(result == listOf(6, 3))
    }

    fun getResult(sc: Scanner, acc: List<Int>): List<Int> {
        val value = sc.nextLine()
        return when (value) {
            "0" -> acc
            else -> getResult(sc, acc.plus(getDigitalRoot(value)))
        }
    }

    fun getDigitalRoot(value: String): Int {
        return if (value.length == 1) {
            value.toInt()
        } else {
            getDigitalRoot(value.toList()
                    .map { it.toInt() - 48 }
                    .reduce { x, y -> x + y }
                    .toString())
        }
    }
}