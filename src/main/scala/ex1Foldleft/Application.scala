package ex1Foldleft

import scala.::


object exercise1  {
  def main(args: Array[String]) {
    val stringToList = args.toList

    def print = {
      val res = stringToList.foldLeft((0, List[String]()) , ( 100 , List[String]())) {
        case ((max ,min), b) =>

        val ifmax: (Int, List[String]) = b.length - max._1 match {
          case m if m > 0 => (b.length , List(b))
          case m if m < 0 => (max._1, max._2)
          case 0 => (max._1, max._2 :+ b )
        }

        val ifmin: (Int, List[String]) = b.length - min._1 match {
          case m if m < 0 => (b.length, List(b))
          case m if m > 0 => (min._1, min._2)
          case 0 => (min._1, min._2 :+ b)
        }
        {
          (ifmax, ifmin)
        }
      }
      res
    }

    println(print)
  }

}
