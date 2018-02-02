// exercism.io - 첫 번 째 풀이
object SaddlePoints extends App {
  println(Matrix(List(List(9, 8, 7), List(5, 3, 2), List(6, 6, 7))).saddlePoints == Set((1, 0)))
  println(Matrix(List(List())).saddlePoints == Set())
  println(Matrix(List(List(1, 2, 3), List(3, 1, 2), List(2, 3, 1))).saddlePoints == Set())
  println(Matrix(List(List(4, 5, 4), List(3, 5, 5), List(1, 5, 4))).saddlePoints == Set((0, 1), (1, 1), (2, 1)))
  println(Matrix(List(List(8, 7, 9), List(6, 7, 6), List(3, 2, 5))).saddlePoints == Set((2, 2)))
}

case class Matrix(matrix: List[List[Int]]) {
  def saddlePoints: Set[(Int, Int)] = {
    matrix match {
      case Nil :: _ => Set()
      case _ =>
        val rowsMax = matrix.map(_.max)
        val columnsMin =  matrix.transpose.map(_.min)
        val ret = for {
          y <- 0 until matrix.size
          x <- 0 until matrix(y).size
          if matrix(y)(x) == rowsMax(y) && matrix(y)(x) == columnsMin(x)
        } yield (y, x)
        ret.toSet
    }
  }
}

