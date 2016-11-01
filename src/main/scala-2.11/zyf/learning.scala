package zyf

/**
  * Created by Zhong on 2016/8/22.
  */
object Learning {

  /**
    * 2.1
    */
  object Fibonacci {

    def fib(n: Int): Int = {
      if (n == 0) {
        0
      } else if (n == 1) {
        1
      } else {
        fib(n - 1) + fib(n - 2)
      }
    }

    def fib2(n: Int): Int = {
      @annotation.tailrec
      def loop(n: Int, prev: Int, cur: Int): Int =
        if (n == 0) prev
        else loop(n - 1, cur, prev + cur)
      loop(n, 0, 1)
    }
  }

  /**
    * 2.2
    */
  object Order {
    def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
      def loop(n: Int): Boolean = {
        if (n >= as.length - 1) true
        else if (ordered(as(n), as(n + 1))) loop(n + 1)
        else false
      }

      loop(0)

    }

    def isSorted2[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
      @annotation.tailrec
      def go(n: Int): Boolean =
        if (n >= as.length - 1) true
        else if (gt(as(n), as(n + 1))) false
        else go(n + 1)

      go(0)
    }

  }

  /**
    *2.3 2.4 2.5
    */
  object Curry {
    def curry[A, B, C](f: (A, B) => C): A => (B => C) =
      (a: A) => ((b: B) => f(a, b))

    def uncurry[A, B, C](f: A => B => C): (A, B) => C =
      (a: A, b:B) => f(a)(b)

    def compose[A, B, C](f: B => C, g: A => B) : A => C =
      (a: A) => f(g(a))
  }

  /**
    *3.12
    */
  object Datastructures {

    def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = l match {
      case Nil => z
      case h :: t => foldLeft(t, f(z,h))(f)
    }


    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
      case Nil => z
      case x :: xs => f(x, foldRight(xs, z)(f))
    }

    def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((acc,h) => h :: acc)
//    def reverse[A](l: List[A]): List[A] = foldRight(l, List[A]())((h,acc) => h :: acc)

  }

  def main(args: Array[String]) {
    println(Fibonacci.fib(3))

    println(Order.isSorted(Array(1, 3, 3), (a: Int, b: Int) => a < b))

    println(Datastructures.reverse(List(1, 2, 3)))

    var a = 1
    a += 1
    a = a + 2

    import scala.math._
    sqrt(2)

    val str = "aaaa"

    "adsfg"(4)

    str.charAt(1)

    str.apply(4)

    "as" * 3

  }
}
