package jang.heesu.study.csv

import scala.util.matching.Regex
/**
 * 정규표현식
 * */
object Regular {
  val REGULAR_SPLIT : Regex = """(?=([^\"]*\"[^\"]*\")*[^\"]*$)""".r

}
