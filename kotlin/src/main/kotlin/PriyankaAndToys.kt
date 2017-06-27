import java.util.Scanner

object PriyankaAndToys {

    @JvmStatic
    fun main(args: Array<String>) {

        val sc = Scanner(System.`in`)
        sc.nextLine()

//        val nums: ArrayList<Int> = arrayListOf()
//
//        for (i in 0 until cases) {
//            nums.add(sc.nextInt())
//        }
//        nums.sort()

        val inputLine = sc.nextLine()
        val nums = inputLine
                .split(" ")
                .map { it.toInt() }
                .toList()
                .sorted()

        println(getResult(nums, 0))
    }

    fun getResult(nums: List<Int>, acc: Int): Int = when {
        nums.isEmpty() -> acc
        else -> {
            val max = nums
                    .mapIndexed {
                        index, _ ->
                        index to convert(nums.subList(index, nums.size))
                    }
                    .maxBy { it.second }

            val subList = nums.subList(max!!.first, max.first + max.second)

            getResult(nums.minus(subList), acc + 1)
        }
    }

    fun convert(nums: List<Int>): Int {
        return nums
                .takeWhile { it <= nums[0] + 4 }
                .count()
    }

}