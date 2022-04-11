package jang.heesu.study.app

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
 * 파일 읽고 조회한 데이터 가공
 *
 * @param
 * */
class ReadInfo {

  def readFileHead(path: String): List[String] ={
    val fileValue = Source.fromFile(path).getLines.toList.head.split(",").toList
    fileValue
  }
  //파일 읽는 기능
  def readFile(path: String ): List[String] ={
    val fileValue = Source.fromFile(path).getLines.toList.tail
    fileValue
  }
  //여러 파일을 동시에 받아오는 기능
  def fileUnion(listFile:List[String]): ArrayBuffer[List[String]] ={
    val multData = ArrayBuffer[List[String]]()
    multData += this.readFileHead(listFile.toList.head)
    for(a<-0 until listFile.length){
      multData += this.readFile(listFile.toList(a).toString)
    }
    multData
  }
  //여러 파일의 내용을 합치는 기능
  def fileSum(multData:ArrayBuffer[List[String]]): List[String] = {
    multData.flatMap(_.toList).toList
  }

  //조회한 컬럼내용 변경기능
  def columnChange(header:List[String],originData:String,changeData:String): List[String] = {
    val changeIdx = header.indexOf(originData)
    if (changeIdx == -1) {
      println("해당 컬럼은 찾을 수 없음")
      header
    } else {
      val newList = header.updated(changeIdx,changeData)
      newList
    }
  }

  def columnChangeNum(header:List[String], originDataIdx:Int, changeData:String): List[String] = {
    if( originDataIdx >= header.length  ) {
      println("해당 컬럼은 존재하지 않습니다")
      header
    }else{
      val newList = header.updated(originDataIdx, changeData)
      newList
    }
  }

}
