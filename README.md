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

1.application.properties에서 spring.datasource.url=jdbc:mysql://localhost:3306/(스키마생성된걸로)?useSSL=false#&?useUnicode=yes&characterEncoding=utf8

<img src="https://user-images.githubusercontent.com/98471267/176724045-f785facf-1db0-483c-a996-27b7a3862543.JPG" width="200" height="200">

2.application.properties에서 spring.jpa.hibernate.ddl-auto=create로 변경 후 스프링 부트 실행하여 테이블 생성

<img src="https://user-images.githubusercontent.com/98471267/176725290-8e808cdc-0213-4748-a0ee-3592eef3c4ae.JPG" width="600" height="300">

3.application.properties에서 spring.jpa.hibernate.ddl-auto=none으로 변경

4.src/test/java 아래 test.mvc 아래 TripleExamApplicationTests.java 에서 useridCreate() 와 placeCreate()를 JUnitTest를 실행시켜준다.
실행방법으로는 useridCreate() 메소드를 블록을 만든뒤 오른쪽 마우스 클릭 후 사진과 같이 각각 실행 시켜주면 된다.

<img src="https://user-images.githubusercontent.com/98471267/176727394-8bb85dfa-4381-422a-96f2-40ff0e628487.JPG" width="400" height="200"><img src="https://user-images.githubusercontent.com/98471267/176727355-18004893-0a9e-4eb3-914b-410b70c509d5.JPG" width="500" height="200">

5.기능구현 및 유효성체크의 편의성을 위해 간단한 test용 tripleReview.jsp파일을 만들었습니다.

6.스프링 부트를 실행 시켜줍니다.(실행전 꼭 위 3번을 해야함)

<img src="https://user-images.githubusercontent.com/98471267/176725290-8e808cdc-0213-4748-a0ee-3592eef3c4ae.JPG" width="600" height="300">

7.서버가 성공적으로 실행되면 http://localhost:8888/tripleReview 로 들어가면 된다.
