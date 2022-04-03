package jang.heesu.study.parser
import jang.heesu.study.csv.CsvInfo
import org.junit.Assert.assertEquals
import org.scalatest.FunSuite

import scala.io.Source

class ParserTest extends FunSuite{
  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }
  test("testRemoveWarapper_1"){
    val wrapper:String = "\""
    val testString = "\"test\""
    val right : String = "test"
    assert(right == Parser.removeWrapper(testString,wrapper))
  }
  test("testRemoveWarapper_2"){
    val wrapper:String = "\""
    val testString = "\"te\"st\""
    val right : String = "te\"st"
    assert(right == Parser.removeWrapper(testString,wrapper))
  }
  test("testRemoveWarapper_3"){
    val wrapper:String = "\""
    val testString = "\"te\"st\""
    val right : String = "te\"st"
    assert(right == Parser.removeWrapper(testString,wrapper))
  }

  test("testsplitLine_1"){
    val line : String =  "0002,B,2,200,2000,\"강남구,서초동\""
    val delimiter : String = ","
    val wrapper:String = "\""

    println("parser line : " + Parser.parseLine(line, delimiter, wrapper))
    println("splitline : " + Parser.splitLine(line,delimiter))
  }

  test("testPatser_1"){
    val path = "src/main/resources/test.csv"
    val line : String =  "0002,B,2,200,2000,\"강남구,서초동\""
    val delimiter : String = ","
    val wrapper:String = "\""

    val csvInfo = new CsvInfo(path, delimiter = ",", wrapper = "\"")
    val parser = Parser.parse(csvInfo,(path:String)=>Source.fromFile(path).getLines.toList)
//    val parser = Parser.parse(csvInfo,(path:String)=>Source.fromFile(path).getLines.toList)

    println("parser : " + parser.bodyValue)
//    println(parser.bodyValue(1).foreach(a=>println(a)))
  }
  test("testPatser_2"){
    val path = "src/main/resources/test.csv"
    val csvInfo = new CsvInfo(path, delimiter = ",", wrapper = "\"")
    val parser = Parser.parse(csvInfo,(path:String)=>Source.fromFile(path).getLines.toList)

//    println("getHeader : " + parser.bodyValue.getHeader())
//    println("getcol int 파라미터 : " + parser.bodyValue.getCol(0))
//    println("getcol string : " + parser.bodyValue.getCol("제품명"))
//    println("getcol where : " + parser.bodyValue.getCol("제품코드", "0003"))
    //assert 로 구현해놓기
    assert(parser.bodyValue.getHeader() == List("제품코드", "제품명", "수량", "단가", "금액", "위치"))
    assert(parser.bodyValue.getCol(0) == List("0001","0002","0003"))
    assert(parser.bodyValue.getCol("제품명") == List("A","B","C"))
    assert(parser.bodyValue.getCol("제품코드","0003") == List("0003","C","3","300","3000","권선구,권선동"))
  }
}
