fun main(args: Array<String>) {
    solve(listOf(10, 5, 20, 20, 4, 5, 2, 25, 1), 9)
    solve2(listOf(10, 5, 20, 20, 4, 5, 2, 25, 1))
    solve3(listOf(10, 5, 20, 20, 4, 5, 2, 25, 1))
    solve3(listOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42))
}

data class RecordedScore(val minScore: Int = 0, val maxScore: Int = 0, val min: Int = 0, val max: Int = 0)

tailrec fun solve(
        scoreList: List<Int>,
        size: Int,
        minScore: Int = 0,
        maxScore: Int = 0,
        min: Int = 0,
        max: Int = 0
) {
    when {
        scoreList.isEmpty() -> println("$max $min")
        scoreList.size == size -> {
            val score = scoreList.first()
            solve(scoreList.drop(1), 9, score, score)
        }
        scoreList.size != size -> {
            val score = scoreList.first()
            solve(
                    scoreList.drop(1),
                    size,
                    if (score < minScore) score else minScore,
                    if (score > maxScore) score else maxScore,
                    if (score < minScore) min + 1 else min,
                    if (score > maxScore) max + 1 else max
            )
        }
    }
}

private tailrec fun solve2(
        scoreList: List<Int>,
        minScore: Int,
        maxScore: Int,
        min: Int = 0,
        max: Int = 0
) {
    when (scoreList.isEmpty()) {
        true -> println("$max $min")
        false -> {
            val score = scoreList.first()
            val scoreLessThenMinScore = score < minScore
            val scoreGreaterThenMinScore = score > maxScore
            solve2(
                    scoreList.drop(1),
                    if (scoreLessThenMinScore) score else minScore,
                    if (scoreGreaterThenMinScore) score else maxScore,
                    if (scoreLessThenMinScore) min + 1 else min,
                    if (scoreGreaterThenMinScore) max + 1 else max
            )
        }
    }
}

fun solve2(scoreList: List<Int>) {
    val init = scoreList.first()
    solve2(scoreList.drop(1), init, init)
}

fun solve3(scoreList: List<Int>) = scoreList.foldIndexed(RecordedScore()) { i, record, score ->
    when (i) {
        0 -> RecordedScore(score, score)
        else -> RecordedScore(
                Math.min(score, record.minScore),
                Math.max(score, record.maxScore),
                if (score < record.minScore) record.min + 1 else record.min,
                if (score > record.maxScore) record.max + 1 else record.max
        )
    }
}.also { println("${it.max} ${it.min}") }