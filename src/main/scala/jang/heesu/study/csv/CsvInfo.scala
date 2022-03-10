package jang.heesu.study.csv

//TODO Csv 파일에대한 정보 Class
class CsvInfo(path: String, delimiter: String, wrapper: String) {


  def getPath: String = {
    path
  }

  def getDelimiter: String = {
    delimiter
  }

  def getWrapper: String = {
    wrapper
  }

}
