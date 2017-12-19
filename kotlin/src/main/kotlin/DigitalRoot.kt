import java.util.Scanner

/**
 * Created by Lazysoul on 2017. 7. 18..
 */
object DigitalRoot {

    @JvmStatic
    fun main(args: Array<String>) {

        val sc = Scanner(System.`in`)
        val result = getResult(sc, listOf())

        val  list = listOf(1,2,3,4,5)

        list.drop(1)

        for(i in 0..6)

        require(result == listOf(6, 3))
    }

    tailrec fun getResult(sc: Scanner, acc: List<Int>): List<Int> {
        val value = sc.nextLine()
        return when (value) {
            "0" -> acc
            else -> getResult(sc, acc.plus(getDigitalRoot(value)))
        }
    }

    tailrec fun getDigitalRoot(value: String): Int {
        return if (value.length == 1) {
            value.toInt()
        } else {
            getDigitalRoot(value
                    .map { it.toInt() - 48 }
                    .reduce { x, y -> x + y }
                    .toString())
        }
    }
}