import jang.heesu.study.csv.{CsvInfo, csvBody, csvHeader}
import jang.heesu.study.scalaTest.scalaTestDivision
import org.junit.Assert.assertEquals

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

class scalaTest {
  @org.junit.Test
  def test1(): Unit = {
    val exepected : Int = 10
    val actual : Int = scalaTestDivision.Division(55,5)
    assertEquals(exepected, actual)
  }
  //csv 파일 찾아서 데이터 조회 test
  @org.junit.Test
  def csvPathTest: Unit ={
    val c1 = new CsvInfo("src/main/resources/test.csv",",","")
    val pathArray = c1.getPath
    println("partarray : " + pathArray.toList )
  }
  //구분자로 split test
  @org.junit.Test
  def getDelimiterTest: Unit ={
    val Delimiter = ","
    val c1 = new CsvInfo("src/main/resources/test.csv",",","")
    c1.getDelimiter(c1.getPath)
    val headerValue = new csvHeader
    val bodyValue = new csvBody
    val pathArray = c1.getPath
    val pathArraySplit = ArrayBuffer[String]()

//    println("asd : " + pathArray(0).split(Delimiter).toList + " || length : " + pathArray(0).split(Delimiter).toList.length)
    pathArray(0).split(Delimiter).foreach(row=>headerValue.csvHeader += row)

    for(a<-1 until pathArray.length){
//        pathArray(a).split(Delimiter).toList.foreach(row=>pathArraySplit += row)
      pathArray(a).split(Delimiter).toList.foreach(row=>bodyValue.csvBody += row)
    }
//    println("*** csvBody.csvBody : " + bodyValue.csvBody + " || length : " + bodyValue.csvBody.length)
  }
}
