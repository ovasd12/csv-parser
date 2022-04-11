package jang.heesu.study.app

import jang.heesu.study.csv.{CsvInfo, CsvValue}
import jang.heesu.study.parser.Parser
import org.scalatest.FunSuite
import org.specs2.control.Functions.toStrictFunction1
import org.specs2.control.Properties.aProperty

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

class ReadInfoTest extends FunSuite {
  test("read file test") {
    val t = new ReadInfo
    val path = "src/main/resources/test.csv"
    println("readinfo file : " + t.readFile(path))

    val csvInfo = new CsvInfo(path, delimiter = ",", wrapper = "\"")
    val parser = Parser.parse(csvInfo,(path:String)=>Source.fromFile(path).getLines.toList)

//    println(parser.CsvValue.getHeader2().toList)
//    parser.CsvValue.getHeader2.toArray()

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
  test("changeColumn"){
//    val testData = Array("제품코드", "제품명", "수량","단가","금액","위치") // 현재 list로 받고 있으므로 컬럼변경을 위해선 array로 변경 필요
    val testData = List("제품코드", "제품명", "수량","단가","금액","위치")
    val standardData = "제품코드"
    val changeData = "제품이름111"
    val changeData2 = "수량량"
    val changeNum = 3
    val changeIdx = testData.indexOf(standardData)

//    testData(changeIdx) = changeData
//    testData(changeNum) = changeData2

    val t = new ReadInfo
    println(t.columnChange(testData,standardData,changeData).toList)
    println(t.columnChangeNum(testData,2,changeData).toList)
  }
  test("ListChangeTest"){
    val testData = List("1","2","3","4")

    val t = testData.updated(0,8)
    println("tttt : " + t)

    val mainList = List(3, 2, 1)

    val mainList2 = mainList.patch(0, Seq(9), 0)
    println("mainList-->"+mainList2)
  }
}
