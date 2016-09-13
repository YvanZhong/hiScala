package zyf

import java.io.{PrintWriter, File}
import scala.io.Source

/**
  * Created by Zhong on 2016/9/12.
  */
object Converter {

  def main(args: Array[String]) {
    val fileList = new File("C:\\Users\\Zhong\\Desktop\\file\\source\\txt").listFiles()

    fileList.foreach{
      f =>
        val fileName = "C:\\Users\\Zhong\\Desktop\\file\\new\\" +"utf8."+f.getName
        val newFile = new File(fileName)
        val writer = new PrintWriter(newFile, "utf8")

        Source.fromFile(f, "GBK").getLines().foreach{
          line =>
            println(line)
            writer.write(line+"\n")
        }
        writer.close()
    }

    println("success")
  }

}
