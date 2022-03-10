package jang.heesu.study.normalizer.dictionary


// 실제 Dictionary를 저장할 객체
trait NormalizeDictionary {

  //  실제 Dictionary 에서 Replace 할거 추상화
  def replace(raw: String): String

}
