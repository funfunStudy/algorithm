fun main(args: Array<String>) {

    require(solve(18) == 4, { "error" })
    require(solve(4) == -1, { "error" })
    require(solve(6) == 2, { "error" })
    require(solve(9) == 3, { "error" })
    require(solve(11) == 3, { "error" })
    require(solve(5000) == 1000, { "error" })
}

private fun solve(number: Int): Int {
    val fiveModResult: Int = (number / 5)
    return recursive(number, fiveModResult)
}

private tailrec fun recursive(number: Int, fiveModResult: Int): Int {
    println("$fiveModResult, $, ${(number - (fiveModResult * 5)) / 3}")
    val threeModResult2 = (number - (fiveModResult * 5)) / 3
    return when {
        number % 5 == 0 -> fiveModResult
        fiveModResult >= 0 -> {
            if ((number - (fiveModResult * 5)) % 3 == 0) {
                fiveModResult + threeModResult2
            } else {
                recursive(number, fiveModResult - 1)
            }
        }
        else -> -1
    }
}