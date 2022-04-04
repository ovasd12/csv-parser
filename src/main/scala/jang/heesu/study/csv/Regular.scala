package jang.heesu.study.csv

import scala.util.matching.Regex

object Regular {
  val REGULAR_SPLIT : Regex = """(?=([^\"]*\"[^\"]*\")*[^\"]*$)""".r

}
