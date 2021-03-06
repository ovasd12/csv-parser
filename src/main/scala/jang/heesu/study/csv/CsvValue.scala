package jang.heesu.study.csv

import scala.collection.mutable.ArrayBuffer
/**
 * value 값의 대한 참조변수
 * @param idx : 데이터 조회시 컬럼위치 index 값
 * @param colName : 데이터 조회시 컬럼명
 * @param colValue : 데이터 조회시 컬럼valye 값
 * */
class CsvValue extends ArrayBuffer[List[String]] with CsvAbst {

  override def getHeader(): List[String] = {
    this.head
  }
  override def getCol(idx: Int): List[String] = {
    this.tail.map(x => x(idx)).toList
  }
  override def getCol(colName: String): List[String] = {
    val colNameIndex = this.head.indexOf(colName)
    this.tail.map(x => x(colNameIndex)).toList
  }
  override def getCol(colName:String, colValue:String): List[String] = {
    val colNameIndex = this.head.indexOf(colName)
    this.tail.filter(x => x(colNameIndex) == colValue).flatMap(_.toList).toList
  }
}
