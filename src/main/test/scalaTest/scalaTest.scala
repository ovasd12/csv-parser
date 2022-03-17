import jang.heesu.study.csv.{CsvInfo, csvHeader}
import jang.heesu.study.scalaTest.scalaTestDivision
import org.junit.Assert.assertEquals

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
    val csvHeader = new csvHeader
    val pathArray = c1.getPath
    println("paaaa : " + pathArray.toList)
    val test = Array[String]()
    //배열에 값을 넣고싶은데 에러가 발생함...수정필요
//    println("testasdfasdf : " + test(0))
//    for(a<-0 until pathArray.length){
////      csvHeader.csvHeader(a) = pathArray(a)
//      println("ttt : " + pathArray(a).split(Delimiter).toString)
//    }
//    test.foreach(row=>println(s"$row"))

  }
}
