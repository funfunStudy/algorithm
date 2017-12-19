val MAX = 6

fun main(args: Array<String>) {
//    val sc = Scanner(System.`in`)

//    while (sc.hasNext()) {
//        val line = sc.nextLine()
//        if (line.trim().length == 1) {
//            if (parseInt(line) == 0) {
//                return
//            }
//        } else {
//        }
//    }
    val list1 = "7 1 2 3 4 5 6 7"
    val list2 = "8 1 2 3 5 8 13 21 34"

//    require(getResult(list1
//            .split(" ")
//            .drop(1)
//            .map { it.toInt() }, 0, MAX - 1, MAX - 1, listOf()) ==
//            listOf(
//                    listOf(1, 2, 3, 4, 5, 6),
//                    listOf(1, 2, 3, 4, 5, 7),
//                    listOf(1, 2, 3, 4, 6, 7),
//                    listOf(1, 2, 3, 5, 6, 7),
//                    listOf(1, 2, 4, 5, 6, 7),
//                    listOf(1, 3, 4, 5, 6, 7),
//                    listOf(2, 3, 4, 5, 6, 7)
//            ))

    getResult(list2
            .split(" ")
            .drop(1)
            .map { it.toInt() }, 0, MAX - 1, MAX - 1, listOf()).forEach {
        println(it.joinToString(separator = " "))
    }

    require(getResult(list2
            .split(" ")
            .drop(1)
            .map { it.toInt() }, 0, MAX - 1, MAX - 1, listOf()) ==
            listOf(
                    listOf(1, 2, 3, 5, 8, 13),
                    listOf(1, 2, 3, 5, 8, 21),
                    listOf(1, 2, 3, 5, 8, 34),
                    listOf(1, 2, 3, 5, 13, 21),
                    listOf(1, 2, 3, 5, 21, 34),
                    listOf(1, 2, 3, 8, 13, 21),
                    listOf(1, 2, 3, 8, 13, 34),
                    listOf(1, 2, 3, 8, 21, 34),
                    listOf(1, 2, 3, 13, 21, 34),
                    listOf(1, 2, 5, 8, 13, 21),
                    listOf(1, 2, 5, 8, 13, 34),
                    listOf(1, 2, 5, 8, 21, 34),
                    listOf(1, 2, 5, 13, 21, 34),
                    listOf(1, 2, 8, 13, 21, 34),
                    listOf(1, 3, 5, 8, 13, 21),
                    listOf(1, 3, 5, 8, 13, 34),
                    listOf(1, 3, 5, 8, 21, 34),
                    listOf(1, 3, 5, 13, 21, 34),
                    listOf(1, 3, 8, 13, 21, 34),
                    listOf(1, 5, 8, 13, 21, 34),
                    listOf(2, 3, 5, 8, 13, 21),
                    listOf(2, 3, 5, 8, 13, 34),
                    listOf(2, 3, 5, 7, 21, 34),
                    listOf(2, 3, 5, 13, 21, 34),
                    listOf(2, 3, 8, 13, 21, 34),
                    listOf(2, 5, 8, 13, 21, 34),
                    listOf(3, 5, 8, 13, 21, 34)
            ))
}


fun getResult(list: List<Int>, sIndx: Int, cIndex: Int, pIndex: Int,
        acc: List<List<Int>>): List<List<Int>> = when {
    sIndx + MAX >= list.size || cIndex > list.size -> {
        acc
    }
    pIndex - sIndx + list.size - cIndex < MAX -> {
        when {
            pIndex == sIndx -> {
                println(1)
                getResult(list, sIndx + 1, MAX + sIndx, MAX + sIndx - 1, acc)
            }
            cIndex == list.size -> {
                println(2)
                getResult(list, sIndx, pIndex, pIndex - 1, acc)
            }
            else -> {
                println(3)
                getResult(list, sIndx, cIndex + 1, pIndex, acc)
            }
        }
    }
    else -> {
        if(cIndex == list.size-1){
            println("eq")
        } else {
            println("not eq")
        }
        println("left: ${getLeft(list, sIndx, pIndex)}")
        println("right: ${getRight(list, cIndex, pIndex)}")
        getResult(list, sIndx, cIndex + 1, pIndex,
                acc.plus(listOf(
                        getLeft(list, sIndx, pIndex).plus(getRight(list, cIndex, pIndex)))))

    }
}

fun getLeft(list: List<Int>, sIndx: Int, pIndex: Int): List<Int> = list.drop(sIndx).take(
        pIndex - sIndx)

fun getRight(list: List<Int>, cIndex: Int, pIndex: Int): List<Int> {
    return list.drop(cIndex).take(MAX - pIndex)
}