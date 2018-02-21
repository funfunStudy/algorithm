object Aircondition {
    @JvmStatic
    fun main(args: Array<String>) {
        require(solve(90, listOf(10, 10, 10, 10, 10, 10, 10, 10, 10)))
        require(solve(1000, listOf(77, 77, 70, 11, 34, 35, 41, 83, 54)))
        require(!solve(50, listOf(10, 20, 30, 40, 50, 60, 50, 40, 30)))
    }

    private tailrec fun solve(max: Int, buildings: List<Int>): Boolean = when {
        max < 0 -> false
        buildings.isEmpty() -> max >= 0
        else -> solve(max - buildings.first(), buildings.drop(1))
    }
}