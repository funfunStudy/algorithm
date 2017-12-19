object SimpleBalancedParentheses {
    @JvmStatic
    fun main(args: Array<String>) {
        val positive1 = "(()()()())"
        val positive2 = "(((())))"
        val positive3 = "(()((())()))"

        val negative1 = "((((((())"
        val negative2 = "()))"
        val negative3 = "(()()(()"
        val negative4 = ")(()()(()"

        val bonus1 = "(5+6)∗(7+8)/(4+3)"

        require(solve(positive1.toList(), listOf()))
        require(solve(positive2.toList(), listOf()))
        require(solve(positive3.toList(), listOf()))

        require(!solve(negative1.toList(), listOf()))
        require(!solve(negative2.toList(), listOf()))
        require(!solve(negative3.toList(), listOf()))
        require(!solve(negative4.toList(), listOf()))

        require(solve(bonus1.toList(), listOf()))
    }

    tailrec private fun solve(list: List<Char>, acc: List<Char>): Boolean = when {
        list.isEmpty() -> acc.isEmpty()
        list.first() == ')' && acc.isEmpty() -> false
        list.first() == '(' -> solve(list.drop(1), acc.plus(list.first()))
        list.first() == ')' -> solve(list.drop(1), acc.dropLast(1))
        else -> solve(list.drop(1), acc)
    }
}