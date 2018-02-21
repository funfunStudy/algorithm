fun main(args: Array<String>) {

    require(solve(5, 5) == 4)
    require(solve(4, 5) == 5)
    require(solve(6, 4) == 0)
}

private tailrec fun solve(scoreA: Int, scoreB: Int, acc: Int = 0): Int =
        when {
            scoreA > scoreB -> acc
            scoreA <= scoreB && acc == 0 -> solve(scoreA + 1, scoreB, acc + 4)
            else -> solve(scoreA + 1, scoreB, acc + 1)
        }
