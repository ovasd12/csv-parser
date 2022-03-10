package jang.heesu.study.parser

import com.sun.org.apache.bcel.internal.generic.ArrayType

class ParserDisposal {
  /**
   * method wrapper 제거 기능
   *
   * @Param Array targetData wrapper 로 쌓여진 분석 데이터
   * @Return Array resultData wrapper 가 제거 된 데이터
   * */
  def removeWrapper(targetData : ArrayType): ArrayType = {
    ???
  }

  /**
   * method 공백제거 기능
   *
   * @Param Array targetData 공백이 제거되어져야 할 분석 데이터
   * @Return Array resultData 공백이 제거 된 데이터
   * */
  def removeBlank(targetData : ArrayType): ArrayType = {
    ???
  }

}
