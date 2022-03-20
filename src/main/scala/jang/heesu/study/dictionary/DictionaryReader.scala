package jang.heesu.study.dictionary

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

class DictionaryReader {
  /**
   * method dictionary 읽어오는 기능
   * @param path 사전파일 경로
   * @return NormalizeDictionary 읽어낸 사전내용
   * */
  def read(dictionaryPath:String) : NormalizeDictionary ={
    val dictionayArray = Source.fromFile(dictionaryPath).getLines.toArray

    val dictionary = new NormalizeDictionary {
      override val dictionaryValue: Array[String] = dictionayArray
    }
    return dictionary
  }

}

