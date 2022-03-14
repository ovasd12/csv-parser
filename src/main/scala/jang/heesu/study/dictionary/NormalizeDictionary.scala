package jang.heesu.study.dictionary
/**
 * dictionary 내용 저장할 객체
 * 추상화 된 사전, 어떤 사전이든 지켜야하는 기본값
 * */
trait NormalizeDictionary {
  /**
   * method dictionary 비교하여 사전내용으로 표준화 시켜주는 기능
   * @param raw 사전과 다른 값으로 판단 된 csv 파일 내용
   * @Return String 사전값으로 변경 된 정상적인 값
   * */
  def replace(raw: String): String ={
    ???
  }
}
