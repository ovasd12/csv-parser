import jang.heesu.study.csv.{CsvInfo, csvBody, csvHeader}
import jang.heesu.study.dictionary.DictionaryReader
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

    println("header : " + pathArray(0).split(Delimiter).toList + " || length : " + pathArray(0).split(Delimiter).toList.length)
    pathArray(0).split(Delimiter).foreach(row=>headerValue.csvHeader += row)

    for(a<-1 until pathArray.length){
      pathArray(a).split(Delimiter).toList.foreach(row=>bodyValue.csvBody += row)
    }
    println("*** csvBody.csvBody : " + bodyValue.csvBody + " || length : " + bodyValue.csvBody.length)
  }
  @org.junit.Test
  def getWrapperTest: Unit ={
    val c1 = new CsvInfo("src/main/resources/test.csv",",","\"")
    val path = c1.getPath
    c1.getDelimiter(path)

    val header = c1.headerValue.csvHeader
    val body = c1.bodyValue.csvBody

//    header.foreach(row=>row.replace("\"",""))
//    for(a<-0 until header.length){
//      header(a) = header(a).replace("\"","")
//      println("ddd : " + header(a))
//    }
//    for(a<-0 until body.length){
//      body(a) = body(a).replace("\"","")
//      println("ddd : " + body(a))
//    }
    val headTest = c1.getWrapper(c1.headerValue.csvHeader)
    val bodyTest = c1.getWrapper(c1.bodyValue.csvBody)
    println("headTest : " + headTest + "\nbodyTest : " + bodyTest)
  }
  //dictionary read 기능 테스트
  @org.junit.Test
  def dictionaryReaderTest: Unit = {
    val d = new DictionaryReader
    val test = d.read("src/main/resources/dictionary")
    println("test : " + test.dictionaryValue.toList)
  }
  //사전데이터에 맞는 값으로 수정해주는 기능
  @org.junit.Test
  def replaceTest: Unit = {
    ???
  }
  //비교데이터와 사전을 비교 및 수정
  @org.junit.Test
  def NormalizerTest: Unit = {
    ???
  }

  //call-by-name  방식의 호출 //https://medium.com/@OutOfBedlam/scala-call-by-value-vs-call-by-name-734a79c75ccb
  @org.junit.Test
  def ParserTest(info: CsvInfo, reader: () = (path: String) => List[String]): Unit = {
      println("ddd")

  }

}
