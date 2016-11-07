package zyf

/**
  * Created by Zhong on 2016/8/22.
  */
object TestThread {
  def main(args: Array[String]) {
    val t:Thread = Thread.currentThread()
    println(s"${t.getName}.")
  }
}
