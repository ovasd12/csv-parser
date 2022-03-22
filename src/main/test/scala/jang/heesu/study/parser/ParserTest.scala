package jang.heesu.study.parser
import org.junit.Assert.assertEquals

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
    val line : String =  "제품코드,제품명,수량,단가,금액,위치"
    val delimiter : String = ","
    val wrapper:String = "\""

    println("splitline : " + Parser.splitLine(line,delimiter))
    println("parser line : " + Parser.parseLine(line, delimiter, wrapper))
  }

}
