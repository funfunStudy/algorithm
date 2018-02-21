fun main(args: Array<String>) {
    val test1 = listOf(
            listOf(9, 8, 7),
            listOf(5, 3, 2),
            listOf(6, 6, 7))

    val test2 = listOf(
            listOf(1, 2, 3),
            listOf(3, 1, 2),
            listOf(2, 3, 1))
    val test3 = listOf(
            listOf(4, 5, 4),
            listOf(3, 5, 5),
            listOf(1, 5, 4))

    val test4 = listOf(
            listOf(8, 7, 9),
            listOf(6, 7, 6),
            listOf(3, 2, 5)
    )

    println(solve(test1).filterNotNull())
    println(solve(test2).filterNotNull())
    println(solve(test3).filterNotNull())
    println(solve(test4).filterNotNull())
}

private fun solve(list: List<List<Int>>): List<Pair<Int, Int>?> {
    val xResult = list.map { it.max()!! }.min()
    val yResult = transfer(list, listOf()).map { it.min()!! }.max()

    return if (xResult == yResult) {
        list.foldIndexed(listOf()) { index, acc, lista ->
            acc.plus(lista.mapIndexed { indexa, i -> if(i == xResult) index to indexa else null })
        }
    } else {
        listOf()
    }
}

tailrec fun transfer(list: List<List<Int>>, acc: List<List<Int>>): List<List<Int>> {
    return when {
        list.isEmpty() || list.first().isEmpty() -> acc
        else -> {
            transfer(list.map { it.drop(1) }, acc.plusElement(list.map { it.first() }))
        }
    }
}