package jang.heesu.study.parser

import com.sun.org.apache.bcel.internal.generic.ArrayType


//TODO Line Parser가 여러개일 이유가 있는가? Object로 선언하면 안되는 이유
object LineParser {

  //  TODO ArrayType으로 리턴하는 이유?

  /**
   * 분석파일을 루프 돌며 배열에 넣는 기능
   *
   * @Param String targetFileData
   * @Return Array targetData
   * */
  def repeatParsing(targetFileData: String): ArrayType = {
    ???
  }

  //  TODO 파일 데이터를 읽는다는게 무슨뜻? 변수명이 filepath 아닐까

  /**
   * 파일을 읽는 기능
   *
   * @Param String fileData
   * @Return String targetFileData
   * */
  def findFileData(fileData: String): String = {
    ???
  }

}


