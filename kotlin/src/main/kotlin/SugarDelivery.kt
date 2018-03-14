fun main(args: Array<String>) {
    require(recursive(18) == 4, { "error" })
    require(recursive(4) == -1, { "error" })
    require(recursive(6) == 2, { "error" })
    require(recursive(9) == 3, { "error" })
    require(recursive(11) == 3, { "error" })
    require(recursive(5000) == 1000, { "error" })
}

tailrec fun recursive(number: Int, fiveModResult: Int = number / 5, threeModResult: Int = (number - fiveModResult * 5) / 3): Int =
        when {
            number % 5 == 0 -> fiveModResult
            fiveModResult >= 0 -> {
                if ((number - fiveModResult * 5) % 3 == 0) {
                    fiveModResult + threeModResult
                } else {
                    recursive(number, fiveModResult - 1)
                }
            }
            else -> -1
        }
