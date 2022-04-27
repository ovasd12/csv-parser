package jang.heesu.study.parser

import jang.heesu.study.csv.{CsvInfo, CsvInfoList}
import jang.heesu.study.csv.Regular.REGULAR_SPLIT
/**
 * csv 파일의 내용을 전달받은 구분자와 wrapper 를 제거하여 문자열로 만드는 기능들
 * */
object Parser {
  /**
   * csv 파일의 내용을 dictionary 와 비교하여 정리 된 데이터로 만들어준다
   * @param info  CsvInfo 정보(파일경로, 구분자, Wrapper)
   * @param reader 읽은 파일 데이터
   * @return CsvInfo  파일의 컬럼, value 값
   * */
  def parse(info: CsvInfo, reader:String => List[String]): CsvInfo = {
    val lines:List[String] = reader(info.getPath)
    info.CsvValue ++= lines.map(line => parseLine(line, info.getDelimiter, info.getWrapper))

    info
    }
  def parseList(info: CsvInfoList, reader:List[String] => List[String]): CsvInfoList = {
    val lines:List[String] = reader(info.getPath)
    info.CsvValue ++= lines.map(line => parseLine(line, info.getDelimiter, info.getWrapper))

    info
  }
  /**
   * parsing 할 데이터를 라인별로 구분자와 wrapper 를 제거하여 문자열 만드는 기능
   * @param line  paring 할 데이터
   * @param delimiter 구분자
   * @param wrapper 감싸는 wrapper
   * */
  def parseLine(line:String, delimiter:String, wrapper:String ): List[String] ={
    splitLine(line,delimiter).map(cell => removeWrapper(cell, wrapper))
  }
  /**
   * 구분자로 데이터를 나누는 기능
   * @param line  나눌 데이터
   * @param delimiter 구분자
   * */
  def splitLine(line:String, delimiter:String) : List[String] ={
    val regex = delimiter + REGULAR_SPLIT
    line.split(regex, -1).toList
  }
  /**
   * wrapper 로 감싸져있는 데이터에서 wrapper 제거하는 기능
   * @param cell  wrapper 로 감싸져있는 데이터
   * @param wrapper warpper 문자열
   * */
  def removeWrapper(cell:String, wrapper:String) : String={
    if (isWrapped(cell, wrapper)) cell.trim.substring(1,cell.length-1)
    else cell
  }
  /**
   * wrapper 만 제거하기 위한 조건문
   * @param cell wrapper 로 감싸져있는 데이터
   * @param wrapper wrapper 문자열
   * */
  def isWrapped(cell:String, wrapper:String) : Boolean ={
    cell.head.toString.equals(wrapper) && cell.last.toString.equals(wrapper)
  }

}
