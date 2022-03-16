import jang.heesu.study.csv.CsvInfo
import jang.heesu.study.scalaTest.scalaTestDivision
import org.junit.Assert.assertEquals

class scalaTest {
  @org.junit.Test
  def test1(): Unit = {
    val exepected : Int = 10
    val actual : Int = scalaTestDivision.Division(55,5)
    assertEquals(exepected, actual)
  }

  @org.junit.Test
  def csvTest: Unit ={
    CsvInfo c1 = new CsvInfo("/csv-parser/src/main/resources/test.csv",",","")

  }
}
