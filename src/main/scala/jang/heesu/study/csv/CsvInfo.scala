package jang.heesu.study.csv
/**
 * csv 파일에 대한 정보 저장
 *
 * @Param 분석파일의 경로, 구분자, 감싸는 문자 정보
 * @Return 경로, 구분자, 감싸는 문자정보, csv 컬럼, csv 내용
 * */
class CsvInfo(path: String, delimiter: String, wrapper: String) {

  def getPath: String = {
    path
  }
  //구분자로 csv 파일 내용 나누는 기능 필요
  def getDelimiter: String = {
    delimiter
  }
  //앞뒤로 감싸져 있는 부분 제거기능 필요
  def getWrapper: String = {
    wrapper
  }
  def csvHeader: String = {
    ???
  }
  def csvBody: String = {
    ???
  }
}
