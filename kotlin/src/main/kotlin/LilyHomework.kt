import java.util.*

fun main(args: Array<String>) {
    require(lilysHomework(arrayOf(3, 5, 2, 6, 1)) == 2)
    require(lilysHomework(arrayOf(3, 2, 1)) == 0)
}


fun lilysHomework(arr: Array<Int>): Int {
    val startSize = arr.size

    val asc = asc(Arrays.copyOf(arr, startSize), startSize)
    val desc = desc(Arrays.copyOf(arr, startSize), startSize)
    return if (asc < desc) asc else desc
}


tailrec fun asc(arrays: Array<Int>, startSize: Int, acc: Int = 0): Int {
    return when (arrays.size) {
        0 -> acc
        else -> {
            val firstValue = arrays[0]
            val position = getMinValuePosition(arrays.toList(), 0, firstValue, 0)

            arrays[0] = arrays[position]
            arrays[position] = firstValue

            val arrayCopy = arrays.sliceArray(1 until startSize)
            asc(arrayCopy, startSize - 1, acc + if (position == 0) 0 else 1)
        }
    }
}

tailrec fun desc(arrays: Array<Int>, startSize: Int, acc: Int = 0): Int {
    return when (arrays.size) {
        0 -> acc
        else -> {
            val firstValue = arrays[0]
            val position = getMaxValuePosition(arrays.toList(), 0, firstValue, 0)

            arrays[0] = arrays[position]
            arrays[position] = firstValue

            val arrayCopy = arrays.sliceArray(1 until startSize)
            desc(arrayCopy, startSize - 1, acc + if (position == 0) 0 else 1)
        }
    }
}

tailrec fun getMinValuePosition(
        list: List<Int>,
        position: Int,
        min: Int,
        currentPosition: Int
): Int = when (list.isEmpty()) {
    true -> position
    false -> {
        val firstValue = list[0]
        getMinValuePosition(
                list.drop(1),
                if (min < firstValue) position else currentPosition,
                if (min < firstValue) min else firstValue,
                currentPosition + 1)
    }
}

tailrec fun getMaxValuePosition(list: List<Int>, position: Int, max: Int, currentPosition: Int): Int =
        when (list.isEmpty()) {
            true -> position
            false -> {
                val firstValueInList = list[0]
                getMaxValuePosition(
                        list.drop(1),
                        if (max > firstValueInList) position else currentPosition,
                        if (max > firstValueInList) max else firstValueInList,
                        currentPosition + 1
                )
            }
        }
