package jang.heesu.study.parser

import jang.heesu.study.csv.CsvInfo

//object 키워드로 선언하는 객체는 클래스의 유일한 인스턴스를 넣기 위해 사용
//여러 종류의 인스턴스를 받아도 처리 가능해야하므로 object 로 선언하여 사용
object Parser {
  /**
   * csv 파일의 내용을 dictionary 와 비교하여 정리 된 데이터로 만들어준다
   * @Param csv 파일에 대한 정보, 파일의 내용을 읽는 기능
   * @Return csv 파일의 컬럼, value 값
   * */
    def parse(info: CsvInfo, reader: () = (path: String) => List[String]): CsvInfo = {
        ???
    }

}
