package jang.heesu.study.app

import org.scalatest.FunSuite
import org.specs2.control.Functions.toStrictFunction1
import org.specs2.control.Properties.aProperty

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class ReadInfoTest extends FunSuite {
  test("read file test") {
    val t = new ReadInfo
    val path = "src/main/resources/test.csv"
    println("readinfo file : " + t.readFile(path))
  }

  test("list file read test"){
    val listFile = List("src/main/resources/test.csv", "src/main/resources/test2.csv" , "src/main/resources/test3.csv")
    val t = new ReadInfo
    val z = ArrayBuffer[List[String]]()

    for(a<-0 until listFile.length){
      z += t.readFile(listFile.toList(a).toString)
    }
    println("ddd : " + t.fileUnion(listFile))
  }
}
