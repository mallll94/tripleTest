# 트리플 마일리지 과제

### BULT WITH
- <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white"><img src="https://img.shields.io/badge/JAVA-007396?style=flat-square&logo=java&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=flat-square&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/JPA-232F3E?style=flat-square&logo=aws&logoColor=white">

___ 
### 테스트 케이스 목록
|테스트 케이스|상황|액션|테스트 결과| 
|:---|:---:|:---:|:---:| 
|회원1 첫 리뷰 등록|첫 등록|action: 'ADD' ,content : O ,attachedPhotoIds: O |리뷰 등록 완료, 포인트 3점 증가 |
|회원1 리뷰 중복 등록|리뷰 등록 존재|action: 'ADD' ,content : O ,attachedPhotoIds: O |리뷰 등록 안됨|
|회원1 리뷰 사진 수정|모든 포인트 받은 상황|action: 'MOD' ,content : O ,attachedPhotoIds: X |리뷰 수정 완료, 포인트 1점 감소 |
|회원1 리뷰 내용 수정|모든 포인트 받은 상황|action: 'MOD' ,content : X ,attachedPhotoIds: O |리뷰 수정 완료, 포인트 1점 감소 |
|회원1 리뷰 사진,내용 수정|모든 포인트 받은 상황|action: 'MOD' ,content : X ,attachedPhotoIds: X |리뷰 수정 완료, 포인트 2점 감소 |
|회원1 리뷰 전체 삭제|모든 포인트 받은 상황|action: 'DELETE' ,content : X ,attachedPhotoIds: X |리뷰 수정 완료, 포인트 3점 감소 |
|회원2 리뷰 등록|회원1 첫 등록 뒤|action: 'ADD' ,content : O ,attachedPhotoIds: O |리뷰 등록 완료, 포인트 2점 증가 |
|회원1 삭제 후 회원2 리뷰 등록|회원1 리뷰 삭제 뒤|action: 'ADD','DELETE' ,content : O ,attachedPhotoIds: O |리뷰 등록 완료, 포인트 3점 증가 | 
|회원2 리뷰 등록 후 회원1 삭제|회원1 리뷰 삭제 뒤|action: 'ADD','DELETE' ,content : O ,attachedPhotoIds: O |리뷰 등록 완료, 포인트 2점 증가, 첫 등록 리뷰 삭제후 변화 X | 
|포인트 총점 조회|회원1 포인트||자신의 총 포인트 출력|
|포인트 증가 이력|회원1 포인트 이력||모든 이력 List로 출력|
___ 

### 실행방법

**0.혹시 프로젝트를 푸쉬받은 후 이유 없는 에러가 있다면 querydsl 설치후 에러일 경우가 있다. 그러므로 maven 업데이트가 필요한 경우 일수 있다. 이러한 경우 Quick fix을 사용해 해결할수 있다.**

**1.application.properties에서 spring.datasource.url=jdbc:mysql://localhost:3306/(스키마생성된걸로)?useSSL=false#&?useUnicode=yes&characterEncoding=utf8**

<img src="https://user-images.githubusercontent.com/98471267/176724045-f785facf-1db0-483c-a996-27b7a3862543.JPG" width="200" height="200">

**2.application.properties에서 spring.jpa.hibernate.ddl-auto=create로 변경 후 스프링 부트 실행하여 테이블 생성**

<img src="https://user-images.githubusercontent.com/98471267/176725290-8e808cdc-0213-4748-a0ee-3592eef3c4ae.JPG" width="600" height="300">

**3.application.properties에서 spring.jpa.hibernate.ddl-auto=none으로 변경**

**4.src/test/java 아래 test.mvc 아래 TripleExamApplicationTests.java 에서 useridCreate() 와 placeCreate()를 JUnitTest를 실행시켜줍니다..
실행방법으로는 useridCreate() 메소드를 블록을 만든뒤 오른쪽 마우스 클릭 후 사진과 같이 각각 실행 시켜주면 됩니다..**

<img src="https://user-images.githubusercontent.com/98471267/176727394-8bb85dfa-4381-422a-96f2-40ff0e628487.JPG" width="400" height="200"><img src="https://user-images.githubusercontent.com/98471267/176727355-18004893-0a9e-4eb3-914b-410b70c509d5.JPG" width="500" height="200">

**5.기능구현 및 유효성체크의 편의성을 위해 간단한 test용 tripleReview.jsp파일을 만들었습니다.**

**6.스프링 부트를 실행 시켜줍니다.(실행전 꼭 위 3번을 해야함)**

<img src="https://user-images.githubusercontent.com/98471267/176725290-8e808cdc-0213-4748-a0ee-3592eef3c4ae.JPG" width="600" height="300">

**7.서버가 성공적으로 실행되면 http://localhost:8888/tripleReview 로 들어가면 됩니다..**

<img src="https://user-images.githubusercontent.com/98471267/176730415-6499fe50-7cc3-4dbc-89ea-a8419dbf2d82.JPG" width="600" height="300">

**8.그럼 기본으로 "3ede0ef2-92b7-4817-a5f3-0c575361f745" userId의 보유 포인트,포인트 적립이력테이블,"2e4baf1c-5acb-4efb-a1af-eddada31b00f"의 place 리뷰 목록 테이블, 등록,수정, 자신의 리뷰 전체삭제 하는 버튼이 있습니다.**

**9.순서대로 실행 하는법을 설명하겠습니다.**

**10.리뷰 등록 내용기재,사진은 코드로 대체하였습니다. json으로 변환될때 요구사항과 동일하게 배열값으로 들어가도록 되어있습니다.**

<img src="https://user-images.githubusercontent.com/98471267/176731600-4784d148-2ac4-454c-b700-71d04565ff68.JPG" width="800" height="400">

**11.수정 하기 , 내용을 변경 후 수정 버튼 누르면 내용 변경**

<img src="https://user-images.githubusercontent.com/98471267/176732621-2ddd0414-294e-468c-b011-b27d77ae4c9d.JPG" width="800" height="400">

**12.수정 하기- 사진 내용 삭제 시 포인트 절감 되는 상황, 수정 시 사진 삭제는 내용을 입력 안하면 됩니다. 점수 또한 회수 됩니다.**

<img src="https://user-images.githubusercontent.com/98471267/176733080-6a732380-ead4-47e9-ac23-ea2f76fa5b53.JPG" width="800" height="400">

**13.작성 리뷰 삭제**

<img src="https://user-images.githubusercontent.com/98471267/176733648-dd91e618-291f-4689-a086-280f48ee4707.JPG" width="800" height="400">

**14.아이디 변경후 등록 , 첫등록 추가 포인트 받는지 확인하기 위함
아이디를 변경하기 위해선 src/main/webapp/views/tripleReview.jsp을 연다음 selectAll() 함수의 data 부분의 userId 값을 등록시켜놓은 값으로 변경하면된다.
변경한 userId = 3ede0ef2-92b7-4817-a5f3-0c575361f744 맨뒷자리가 5->4로변경**

<img src="https://user-images.githubusercontent.com/98471267/176736269-9f143707-c2b7-424f-9d33-ee49f227eeb0.JPG" width="800" height="400">

**15.reviewId도 조금 다르게 변경해주면된다. 본인 같은경우 맨뒷자리를 5로 변경**

<img src="https://user-images.githubusercontent.com/98471267/176736827-fc991b85-8f77-4980-be9a-6a7b00c024ca.JPG" width="800" height="300">

**16.사진과 동일하게 5->4 한후 jsp파일 저장 **

<img src="https://user-images.githubusercontent.com/98471267/176736836-7afdb80e-c92a-49f3-a2aa-a005daeb94f8.JPG" width="800" height="300">

**17.새로고침을 누르면 아이디가 변경 되어있을겁니다. 이제 리뷰 회원2로 리뷰 등록을 하게 되면 해당 장소의 첫 리뷰가 아니기때문에 2점을 받는것을 확인가능**
