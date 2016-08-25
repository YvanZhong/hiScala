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

  def main(args: Array[String]) {
    println(Fibonacci.fib(3))

    println(Order.isSorted(Array(1, 3, 3), (a: Int, b: Int) => a < b))

  }
}
