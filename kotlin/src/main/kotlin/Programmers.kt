fun main(args: Array<String>) {

    require(solve(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).contentEquals(intArrayOf(2, 1)))

    require(solve(intArrayOf(40, 93, 30, 55, 60, 65), intArrayOf(60, 1, 30, 5, 10, 7)).contentEquals(intArrayOf(1, 2, 3)))

    require(solve(intArrayOf(93, 30, 55, 60, 40, 65), intArrayOf(1, 30, 5, 10, 60, 7)).contentEquals(intArrayOf(2, 4)))

    require(
            solve(
                    intArrayOf(15, 1, 14, 9, 29, 25, 17, 24, 4, 27, 7, 19, 29, 14, 23, 4, 21, 3, 8, 14),
                    intArrayOf(9, 11, 21, 16, 11, 21, 7, 5, 6, 30, 11, 24, 26, 18, 20, 18, 15, 30, 7, 18)
            ).contentEquals(intArrayOf(6, 1, 13))
    )
}


/*
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses 와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 */
tailrec fun solve(prog: IntArray, spd: IntArray, acc: IntArray = intArrayOf()): IntArray = when {
    prog.isEmpty() -> acc
    prog.first() >= 100 -> {
        val temp = prog.takeWhile { it >= 100 }
        val size = temp.size
        solve(prog.drop(size).toIntArray(), spd.drop(size).toIntArray(), acc.plus(size))
    }
    else -> {
        val temp = zipping(prog, spd)
        solve(temp, spd, acc)
    }
}

fun zipping(prog: IntArray, spd: IntArray): IntArray {
    return prog.zip(spd) { p, s -> p + s }.toIntArray()
}