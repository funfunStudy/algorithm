import kotlin.math.max

fun main(args: Array<String>) {
    val problems = listOf("abcabcbb", "bbbbb", "pwwkew", "", "dvdf", "asjrgapa")
    val expected = listOf(3, 1, 3, 0, 3, 6)

    problems.mapIndexed { index, s -> Pair(solution(s), expected.get(index)) }
            .forEach { (result, expected) ->
                println("result = $result, expected = $expected")
                assert(result == expected)
            }

}

fun solution(str: String): Int {
    return maxLength(substring(str))
}

fun substring(str: String): List<String> {
    return if (str.isEmpty())
        listOf()
    else {
        str.fold(mutableListOf<String>()) { acc, ch ->
            if (acc.size == 0) {
                acc.add("$ch")
            } else {
                val tmp = acc[acc.size - 1]
                if (tmp.contains("$ch")) {
                    acc.add("${tmp.drop(tmp.lastIndexOf(ch) + 1)}$ch")
                } else {
                    acc[acc.size - 1] = "$tmp$ch"
                }
            }
            acc
        }
    }
}

fun maxLength(strs: List<String>): Int {
    return strs.map {
        it.length
    }.takeIf {
        it.size >= 2
    }?.reduce { acc, i ->
        max(acc, i)
    }?: run {
       if (strs.isEmpty()) 0
       else strs[0].length
    }
}


