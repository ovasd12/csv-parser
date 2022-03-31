package jang.heesu.study.csv

import scala.collection.mutable.ArrayBuffer

/**
 * value 값의 대한 참조변수
 * */
class CsvBody extends ArrayBuffer[List[String]] with CsvAbst {
  override def getHeader(): List[String] = ???

  override def getCol(idx: Int): List[String] = ???

  override def getCol(colName: String): List[String] = ???
}
