import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val cases = sc.nextLine().toInt()

    for (i in 0 until cases) {
        val point1 = sc.nextLine().split(" ")
        val point2 = sc.nextLine().split(" ")
        val point3 = sc.nextLine().split(" ")

//        listOf(point1, point2, point3)
        val t1 = System.currentTimeMillis()
        val x1 = getResultViaGroupBy(listOf(point1[0], point2[0], point3[0]))
        val y1 = getResultViaGroupBy(listOf(point1[1], point2[1], point3[1]))
        println("$x1 $y1")
        println("groupBy : ${System.currentTimeMillis() - t1}")

        val t2 = System.currentTimeMillis()
        val x = getResultViaFold(listOf(point1[0], point2[0], point3[0]))
        val y = getResultViaFold(listOf(point1[1], point2[1], point3[1]))
        println("$x $y")
        println("fold : ${System.currentTimeMillis() - t2}")
    }
}

fun getResultViaGroupBy(list: List<String>): String =
        list.groupBy { it }
                .filter { it.value.size == 1 }
                .map { it.key }
                .toString()


fun getResultViaFold(list: List<String>): String =
        list.fold(listOf<String>(), { acc, value ->
            if (!acc.contains(value)) {
                acc.plus(value)
            } else {
                acc.minus(value)
            }
        }).first()
