package jang.heesu.study.app

import jang.heesu.study.csv.{CsvInfo, CsvInfoList}
import jang.heesu.study.parser.Parser
import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer
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
  test("total data of print test"){
    val listFile = List("src/main/resources/test.csv", "src/main/resources/test2.csv" , "src/main/resources/test3.csv")
    val fileData = ArrayBuffer[List[String]]()
    val csvInfoList = new CsvInfoList(listFile,delimiter = ",", wrapper = "\"")

    val readInfo = new ReadInfo
    Parser.parseList(csvInfoList, (listFile:List[String])=>listFile)
    println("totalData : " + readInfo.fileUnion(listFile).flatten.toList)
    println("aaaa : " + csvInfoList.CsvValue)

    val path = "src/main/resources/test.csv"
    val csvInfo = new CsvInfo(path, delimiter = ",", wrapper = "\"")
    Parser.parse(csvInfo,(path:String)=>Source.fromFile(path).getLines.toList)
    println("parser : " + flattenString(csvInfo) )
  }
  def flattenString(info:CsvInfo): List[String] ={
    info.CsvValue.flatten.toList
  }
  def flattenString2(infoList:CsvInfoList): List[String] ={
    infoList.CsvValue.flatten.toList
  }

  /**
  * 1. map, foreach, flatten, flatmap
   * 2. 전체 항목 조회 후 뒤에 "a" 붙이기
  * */
}
