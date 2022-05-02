package jang.heesu.study.app

import jang.heesu.study.csv.{CsvInfo, CsvInfoList}
import jang.heesu.study.parser.Parser
import org.scalatest.FunSuite
import scala.io.Source

class ReadInfoTest extends FunSuite {
  test("read file test") {
    val t = new ReadInfo
    val path = "src/main/resources/test.csv"
    println("readinfo file : " + t.readFile(path))

    val csvInfo = new CsvInfo(path, delimiter = ",", wrapper = "\"")
    val parser = Parser.parse(csvInfo,(path:String)=>Source.fromFile(path).getLines.toList)
  }
  test("read file of list test"){
    val listFile = List("src/main/resources/test.csv", "src/main/resources/test2.csv" , "src/main/resources/test3.csv")
    val readInfo = new ReadInfo

    println("totalData : " + readInfo.fileUnion(listFile))
  }
  test("change column with column name"){
    val testData = List("제품코드", "제품명", "수량","단가","금액","위치")
    val standardData = "제품코드"
    val changeData = "제품이름111"

    val t = new ReadInfo
    println(t.columnChange(testData,standardData,changeData).toList)
    println(t.columnChangeNum(testData,2,changeData).toList)
  }
  test("update list Test"){
    val testData = List("1","2","3","4")

    val changeData = testData.updated(0,8)
    println("changeData : " + changeData)

    val mainList = List(3, 2, 1)

    val mainList2 = mainList.patch(0, Seq(9), 0)
    println("mainList-->"+mainList2)
  }
  test("Test of flattenString"){
    val listFile = List("src/main/resources/test.csv", "src/main/resources/test2.csv" , "src/main/resources/test3.csv")
    val path = "src/main/resources/test.csv"
    val readInfo = new ReadInfo
    val fileData = readInfo.fileUnion(listFile)
    val csvInfo = new CsvInfo(listFile(0), delimiter = ",", wrapper = "\"")
    Parser.parse(csvInfo,(listFile:String)=>fileData.flatten.toList)
    println("flattenString test111 : " + flattenString(csvInfo))
  }
  test("parser test of total data "){
    val listFile = List("src/main/resources/test.csv", "src/main/resources/test2.csv" , "src/main/resources/test3.csv")
    val readInfo = new ReadInfo
    val fileData = readInfo.fileUnion(listFile)
    val csvInfoList = new CsvInfoList(listFile, delimiter = ",", wrapper = "\"")
    Parser.parseList(csvInfoList,(listFile:List[String])=>fileData.flatten.toList)
    println("parserList : " + flattenList(csvInfoList) )
  }
  def flattenString(info:CsvInfo): List[String] ={
    info.CsvValue.flatten.toList
  }
  def flattenList(info:CsvInfoList): List[String] ={
    info.CsvValue.flatten.toList
  }
  test("test of list add char"){
    val listFile = List("src/main/resources/test.csv", "src/main/resources/test2.csv" , "src/main/resources/test3.csv")
    val readInfo = new ReadInfo
    val fileData = readInfo.fileUnion(listFile)
    val csvInfoList = new CsvInfoList(listFile,delimiter = ",", wrapper = "\"")
    Parser.parseList(csvInfoList,(_:List[String])=>fileData.flatten.toList)
//    val addChar = flattenList(csvInfoList).map{ x => x + "aa"}
    val addCharTest = addChar(csvInfoList)
    println("addCharTest : " + addCharTest)
    flattenList(csvInfoList).foreach(a=>println(s"$a" + "aa"))
  }
  def addChar(info:CsvInfoList): List[String] ={
    flattenList(info).map{x => x + "aa"}
  }

}
