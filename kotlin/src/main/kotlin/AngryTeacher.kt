object AngryTeacher {

    @JvmStatic
    fun main(args: Array<String>) {
        require(solve(3, arrayOf(-1, -3, 4, 2)) == "YES")
        require(solve(2, arrayOf(0, -1, 2, 1)) == "NO")
        require(solve(0, arrayOf()) == "NO")
        require(solve(4, arrayOf(-93, -86, 49, -62, -90, -63, 40, 72, 11, 67)) == "NO")
        require(solve(10, arrayOf(23, -35, -2, 58, -67, -56, -42, -73, -19, 37)) == "YES")
        require(solve(9, arrayOf(13, 91, 56, -62, 96, -5, -84, -36, -46, -13)) == "YES")
        require(solve(8, arrayOf(45, 67, 64, -50, -8, 78, 84, -51, 99, 60)) == "YES")
    }

    private tailrec fun solve(limit: Int, students: Array<Int>, acc: Int = 0): String =
            when {
                acc == 0 && students.isEmpty() -> "NO"
                students.isEmpty() -> if (limit > acc) "YES" else "NO"
                else -> {
                    val head = students[0]
                    solve(limit, students.sliceArray(1 until students.size), if (head > 0) acc + 1 else acc)
                }
            }

}