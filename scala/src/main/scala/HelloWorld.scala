import java.util.Scanner

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases = sc.nextInt

    for (_ <- 0 until cases) {
      val name = sc.next()
      println(s"Hello, $name!")
    }
  }
}
