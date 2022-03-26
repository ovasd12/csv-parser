package jang.heesu.study.parser
import jang.heesu.study.csv.CsvInfo
import org.junit.Assert.assertEquals

import scala.io.Source

class ParserTest {
  @org.junit.Test
  def testRemoveWarapper_1() ={
    val wrapper:String = "\""
    val testString = "\"test\""
    val right : String = "test"
    assertEquals(Parser.removeWrapper(testString,wrapper), right)
  }
  @org.junit.Test
  def testRemoveWarapper_2() ={
    val wrapper:String = "\""
    val testString = "\"te\"st\""
    val right : String = "te\"st"
//    assertEquals( right, Parser.removeWrapper(testString,wrapper))
    assertEquals(Parser.removeWrapper(testString,wrapper), right)
  }
  @org.junit.Test
  def testRemoveWarapper_3() ={
    val wrapper:String = "\""
    val testString = " \"te\"st\""
    val right : String = "te\"st"
//    assertEquals( right, Parser.removeWrapper(testString,wrapper))
    assertEquals(Parser.removeWrapper(testString,wrapper), right)

  }
  @org.junit.Test
  def testsplitLine_1: Unit ={
    val line : String =  "0002,B,2,200,2000,\"강남구,서초동\""
    val delimiter : String = ","
    val wrapper:String = "\""

    println("splitline : " + Parser.splitLine(line,delimiter))
    println("parser line : " + Parser.parseLine(line, delimiter, wrapper))
  }
  @org.junit.Test
  def testPatser_1: Unit ={
    val path = "src/main/resources/test.csv"
    val line : String =  "0002,B,2,200,2000,\"강남구,서초동\""
    val delimiter : String = ","
    val wrapper:String = "\""

    val csvInfo = new CsvInfo(path, delimiter = ",", wrapper = "\"")
    val parser = Parser.parse(csvInfo,(path:String)=>Source.fromFile(path).getLines.toList)

    println(parser.headerValue.csvHeader)
    println(parser.bodyValue.csvBody)


  }
}
