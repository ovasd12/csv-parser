package jang.heesu.study.csv
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
/**
 * csv 파일에 대한 정보 저장(csv 컬럼, csv 내용)
 * @param path 분석파일의 경로
 * @param delimiter 파일내 구분자
 * @param wrapper 파일내 감싸는 문자
 * header, body 를 더 잘게 쪼개서 List[String] 로 모아두면 더 좋을 것
 * */
class CsvInfo(path: String, delimiter: String, wrapper: String) {
  val CsvValue = new CsvValue
  /**
   * 분석파일의 대한 경로
   * */
  def getPath: String= {
    path
  }
  /**
   * 구분자
   * */
  def getDelimiter: String = {
    delimiter
  }
  /**
   * 앞뒤로 감싼 Wrapper
   * */
  def getWrapper: String = {
    wrapper
  }
}
class CsvInfoList(path: List[String], delimiter: String, wrapper: String) {
  val CsvValue = new CsvValue
  /**
   * 분석파일의 대한 경로
   * */
  def getPath: List[String]= {
    path
  }
  /**
   * 구분자
   * */
  def getDelimiter: String = {
    delimiter
  }
  /**
   * 앞뒤로 감싼 Wrapper
   * */
  def getWrapper: String = {
    wrapper
  }
}
