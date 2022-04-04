package jang.heesu.study.app

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
 * 파일 읽고 조회한 데이터 가공
 *
 * @param
 * */
class ReadInfo {

  //파일 읽는 기능
  def readFile(path: String ): List[String] ={
    val fileValue = Source.fromFile(path).getLines.toList
    fileValue
  }
  //여러 파일을 동시에 받아오는 기능
  def fileUnion(listFile:List[String]): ArrayBuffer[List[String]] ={
    val multData = ArrayBuffer[List[String]]()
    for(a<-0 until listFile.length){
      multData += this.readFile(listFile.toList(a).toString)
    }
    multData
  }
  //여러 파일의 내용을 합치는 기능
  def fileSum: Unit ={
    ???
  }
  //조회한 컬럼내용 변경기능
  def columChange: Unit ={
    ???
  }
}
