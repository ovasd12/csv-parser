package jang.heesu.study.normalizer.dictionary

import com.sun.org.apache.bcel.internal.generic.ArrayType

class DictionaryFilter {
  /**
   * method dictionary 비교 및 체크 기능
   * @Param Array line 분석할 라인
   * @Return Array fixData 수정이 필요한 데이터 배열
   * */
  def compareDictionary(line: ArrayType): ArrayType = {
    ???
  }

  /**
   * method dictionary 내용으로 치환 기능
   * @Param Array fixData 수정이 필요한 데이터들의 배열
   * @Return Array resultData dictionary 정보로 수정 된 데이터 라인
   * */
  def replaceDictionary(resultData: ArrayType): ArrayType = {
    ???
  }

}
