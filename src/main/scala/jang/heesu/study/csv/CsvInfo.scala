package jang.heesu.study.csv
import scala.io.Source
/**
 * csv 파일에 대한 정보 저장(csv 컬럼, csv 내용)
 *
 * @param path 분석파일의 경로
 * @param delimiter 파일내 구분자
 * @param wrapper 파일내 감싸는 문자
 * header, body 를 더 잘게 쪼개서 List[String] 로 모아두면 더 좋을 것
 * */
class CsvInfo(path: String, delimiter: String, wrapper: String) {

  //파일의 경로 정보 return
  def getPath: Array[String] = {
    val pathArray = Source.fromFile(path).getLines.toArray
    return pathArray
  }
  //구분자로 csv 파일 내용 나누는 기능 필요
  def getDelimiter: String = {
    delimiter
  }
  //앞뒤로 감싸져 있는 부분 제거기능 필요
  def getWrapper: String = {
    wrapper
  }


}
