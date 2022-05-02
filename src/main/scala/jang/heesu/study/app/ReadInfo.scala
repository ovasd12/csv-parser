package jang.heesu.study.app

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
 * 파일 읽고 조회한 데이터 가공
 * */
class ReadInfo {
  /**
   * 파일 head 에 대한 정보 read
   * 파일에 head 가 중복으로 있으므로 해당 함수로 한번의 head 정보 가져옴
   * @param path 파일의 대한 경로
   * */
  def readFileHead(path: String): List[String] ={
    val fileValue = Source.fromFile(path).getLines.toList.head.split(",").toList
    fileValue
  }
  /**
   * 파일 읽기 기능
   * @param path 파일에 대한 경로
   * */
  def readFile(path: String ): List[String] ={
    val fileValue = Source.fromFile(path).getLines.toList.tail
    fileValue
  }
  /**
   * 여러 파일을 동시에 받아오는 기능
   * @param listFile 여러파일에 대한 데이터 정보
   *                 @return union data
   * */
  def fileUnion(listFile:List[String]): List[List[String]] ={
//    val multData = ArrayBuffer[List[String]]()
//    multData += this.readFileHead(listFile.head)
//    listFile.foreach(row => {
//      multData += this.readFile(row)
//    })
//    multData
    println("ddd : " + readFile(listFile.head))
    List(readFile(listFile.head)) ++ listFile.map(file=>readFile(file).tail)
  }
  /**
   * 여러 파일의 내용을 합치는 기능
   * @param multData
   * */
  def fileSum(multData:ArrayBuffer[List[String]]): List[String] = {
    multData.flatMap(_.toList).toList
  }
  /**
   * 컬럼으로 조회한 컬럼내용 변경기능
   * @param header
   * @param originData
   * @param changeData
   * */
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
  /**
   * 인덱스로 조회한 컬럼내용 변경기능
   * @param header
   * @param originData
   * @param changeData
   * */
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
