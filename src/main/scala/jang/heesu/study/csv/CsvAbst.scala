package jang.heesu.study.csv
/**
 * CsvInfo 정보 중 필수적으로 구현되어져야 하는 함수들
 * @param idx : 데이터 조회시 컬럼위치 index 값
 * @param colName : 데이터 조회시 컬럼명
 * @param colValue : 데이터 조회시 컬럼valye 값
 * */
trait CsvAbst {
  def getHeader():List[String]

  def getCol(idx:Int):List[String]

  def getCol(colName:String):List[String]

  def getCol(colName:String, colValue:String):List[String]

}
