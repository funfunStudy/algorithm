object Color extends Enumeration {
	val RED = Value(0)
	val GREEN = Value(1)
	val BLUE = Value(2)
}

object RGBDistance {
	def recursive(count: Int, color: Color.Value, arr: List[List[Int]]): Int = {
		if (arr.size - 1 == count) return arr(count)(color.id)

		val current = arr(count)(color.id)
		color match {
			case Color.RED =>
				val green = recursive(count + 1, Color.GREEN, arr)
				val blue = recursive(count + 1, Color.BLUE, arr)
				current + Math.min(green, blue)
			case Color.GREEN =>
				val red = recursive(count + 1, Color.RED, arr)
				val blue = recursive(count + 1, Color.BLUE, arr)
				current + Math.min(red, blue)
			case Color.BLUE =>
				val red = recursive(count + 1, Color.RED, arr)
				val green = recursive(count + 1, Color.GREEN, arr)
				current + Math.min(red, green)
		}
	}

	def main(args: Array[String]): Unit = {
		val arr: List[List[Int]] = List(List(26, 40, 83), List(49, 60, 57), List(13, 89, 99))
		val arr2: List[List[Int]] = List(List(1, 20, 30), List(50, 5, 6), List(9, 3, 7))

		val result = Math.min(recursive(0, Color.RED, arr), Math.min(recursive(0, Color.GREEN, arr), recursive(0, Color.BLUE, arr)))
		val result2 = Math.min(recursive(0, Color.RED, arr2), Math.min(recursive(0, Color.GREEN, arr2), recursive(0, Color.BLUE, arr2)))
		println(result)
		println(result2)
	}
}
