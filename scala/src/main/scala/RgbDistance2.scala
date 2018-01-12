object RgbDistance {
  object Colors extends Enumeration {
    val Red, Green, Blue = Value
    val size = values.size
    type Color = Value
    implicit def toInt(c: Color): Int = c.id
    implicit class ColorOps(color: Color) {
      def left: Color = Colors(Math.floorMod(color - 1, size))
      def right: Color = Colors(Math.floorMod(color + 1, size))
    }
  }

  import Colors._
  type Houses = List[List[Int]]

  def process(inputs: Houses): Int = {
    def loop(color: Color, price: Int, remains: Houses): Int = {
      remains match {
        case Nil => price
        case h :: t =>
            price + math.min(
              loop(color.left, h(color.left), t),
              loop(color.right, h(color.right), t))
      }
    }

    inputs match {
      case h :: t =>
        List(loop(Red, h(Red), t),
          loop(Green, h(Green), t),
          loop(Green, h(Green), t)).min
    }
  }
}

object Main extends App {
  val inputs1 = List(List(26, 40, 83), List(49, 60, 57), List(13, 89, 99))
  val inputs2 = List(List(1, 20, 30), List(50, 5, 6), List(9, 3, 7))
  val inputs3 = List(List(1, 2, 3), List(4, 5, 6))
  println(RgbDistance.process(inputs1))
  println(RgbDistance.process(inputs2))
  println(RgbDistance.process(inputs3))
}




