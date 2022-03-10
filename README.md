# csv-parser 정의
쉼표로 구분되어져 있는 파일 구문 분석
사전을 통해 오타를 정규화 

### parser 구동방식
1. 파일의 첫번째 줄 데이터를 저장
2. 저장된 첫번째 줄을 사전을 비교하여 확인 및 사전의 정상적인 값으로 수정
3. 각 줄 루프를 돌면서 내용 파싱
   1. 라인의 내용을 separator 로 나눔
   2. 저장할 문자열의 맨 앞, 맨뒤 wrapper 문자 제거
   3. 저장할 문자열의 선행, 후행 공백 제거
   4. 문자열의 데이터를 사전과 비교하여 정상적으로 확인 된 값으로 치환
   5. 문자열을 읽으며 읽고있는 파일의 데이터 끝에 도달하면 종료
4. 분석 중인 파일닫기

### 필요한 함수
- 저장할 문자열의 내용과 사전을 비교하여 정상유무 판단해주는 함수 
- 사전의 정상적인 값으로 수정해주는 함수
- 저정할 문자열을 separator 기준으로 나눠주는 기능을 가진 함수
- 공란 및 wrapper 문자 제거해주는 함수
- 문자열을 읽으며 파일의 내용을 저장하는 함수

### 필요한 클래스
- 저장할 문자열을 사전과 비교 및 정상적인 값으로 수정해주는 클래스
- 저장할 문자열을 공란 및 wrapper 제거해주며 separator 기준으로 나눠주는 클래스
- 저장할 문자열을 루프를 돌며 저장하는 클래스

### 패키지 구조 구상
````bash
package - CsvParser (파일구문 분석)
  ⎿ class 분석파일의 라인을 루프를 돌며 수행 기능 // LineParser
      ⎿ method 분석파일 루프 // repeatParsing
      ⎿ method 분석파일 불러오기 // findFileData
  ⎿ class wrapper, 공백 제거 기능 // ParserDisposal
      ⎿ method wrapper 제거 기능 // removeWrapper
      ⎿ method 공백제거 기능      // removeBlank
   ⎿ class dictionary 비교 및 치환 기능 // DictionaryFilter
      ⎿ method dictionary 비교 및 체크 기능 // compareDictionary
      ⎿ method dictionary 내용으로 치환 기능 // replaceDictionary
        
````
