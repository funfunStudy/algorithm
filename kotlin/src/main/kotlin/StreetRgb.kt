fun main(args: Array<String>) {
    val list: List<List<Int>> = listOf(listOf(26, 40, 83), listOf(49, 60, 57), listOf(13, 89, 99))
    val list2: List<List<Int>> = listOf(listOf(1, 20, 30), listOf(50, 5, 6), listOf(9, 3, 7))

    println(solve(list))
    println(solve(list2))

}

fun solve(list: List<List<Int>>, index: Int = 0, min: Int = 0): Int = when {
    list.isEmpty() || index == 3 -> min
    else -> solve(list, index + 1, findMin(list, index, 0, min))
}

fun findMin(list: List<List<Int>>, index: Int, result: Int = 0, min: Int): Int = when {
    list.isEmpty() -> {
        if (min == 0)
            result
        else {
            if (min > result) {
                result
            } else {
                min
            }
        }
    }
    else -> {
        when (index) {
            0 -> Math.min(//RED
                    findMin(list.drop(1), 1, result + list.first()[index], min),
                    findMin(list.drop(1), 2, result + list.first()[index], min))
            1 -> Math.min(//Green
                    findMin(list.drop(1), 0, result + list.first()[index], min),
                    findMin(list.drop(1), 2, result + list.first()[index], min))
            2 -> Math.min(//Blue
                    findMin(list.drop(1), 0, result + list.first()[index], min),
                    findMin(list.drop(1), 1, result + list.first()[index], min))
            else -> {
                result
            }
        }
    }
}

/*
예제 입력
3
26 40 83
49 60 57
13 89 99

3
1 20 30
50 5 6
9 3 7

예제 출력
96

10
*/

