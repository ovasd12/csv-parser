package jang.heesu.study.csv

trait CsvAbst {

  def getHeader():List[String]

  def getCol(idx:Int):List[String]

  def getCol(colName:String):List[String]

  def getCol(colName:String, colValue:String):List[String]

}
