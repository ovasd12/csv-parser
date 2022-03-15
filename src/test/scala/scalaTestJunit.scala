import jang.heesu.study.scalaTest.scalaTestDivision
import org.junit.Assert.assertEquals

class scalaTestJunit {
  @org.junit.Test
    def test1(): Unit = {
      val exepected : Int = 10
      val actual : Int = scalaTestDivision.Division(55,5)
      assertEquals(exepected, actual)
    }
}
