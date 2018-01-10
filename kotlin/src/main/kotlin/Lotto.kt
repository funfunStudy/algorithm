import java.lang.Integer.parseInt
import java.util.Scanner

val MAX = 6

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    while (sc.hasNext()) {
        val line = sc.nextLine()
        if (line.trim().length == 1) {
            if (parseInt(line) == 0) {
                return
            }
        } else {
            val splits = line.split(" ")
            val size = parseInt(splits.first())
            val labels = splits.takeLast(size).map{it.toInt()}

            printOut(getResult(labels, 0, MAX - 1, listOf()))
        }
    }




}


fun getResult(list: List<Int>, sIndx:Int, cIndex:Int, acc: List<Int>) : List<Int> = when {
        sIndx + MAX < list.size -> acc
        cIndex >= list.size -> getResult(list, sIndx+1, MAX, acc.plus(list.take(MAX-1).plus(listOf(list[cIndex]))))
        cIndex < list.size -> getResult(list, sIndx, cIndex+1, acc.plus(list.take(MAX-1).plus(listOf(list[cIndex]))))
    else -> acc
    }



fun printOut(result: List<Int>) {
    println(result.joinToString(separator = " "))

}
