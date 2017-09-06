object FindLargestSquare {

    @JvmStatic
    fun main(args: Array<String>) {

        val board = listOf(
                listOf('X', 'O', 'O', 'O', 'X', 'O', 'O', 'O'),
                listOf('X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'),
                listOf('X', 'X', 'X', 'X', 'X', 'O', 'O', 'O'))

        val value = findLargestSquare(board, 0, 0, 0)
        val result = value * value

        println("result : $result")

    }

    private tailrec fun findLargestSquare(board: List<List<Char>>, x: Int, y: Int, max: Int): Int {
        val maxHeight = board.size
        val maxWidth = board.first().size
        return when {
            x == maxWidth - 1 && y == maxHeight - 1 -> max
            maxHeight - y <= max -> max
            maxWidth - x <= max -> findLargestSquare(board, 0, y + 1, max)
            else -> findLargestSquare(board, x + 1, y,
                    maxOf(max, getMaxValue(board, x, y, 0)))
        }
    }

    private tailrec fun getMaxValue(board: List<List<Char>>, x: Int, y: Int, max: Int): Int {
        if (board.size <= y + max || board.first().size <= x + max) {
            return max
        }
        for (i in y..y + max) {
            (x..x + max)
                    .filter { board[i][it] == 'X' }
                    .forEach { return max }
        }
        return getMaxValue(board, x, y, max + 1)
    }
}