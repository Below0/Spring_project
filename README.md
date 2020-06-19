# 스프링 프로젝트 7단계

+ TDD 코드 작성

+ REST API 적용

+ TDD 기반 리팩토링 적용

+ Repository 도메인 추가를 통한 모듈화

+ 인터페이스를 이용한 객체 의존성 주입

+ **레이어 분리**
  + **인터페이스 : 컨트롤러**
  
  + **도메인 : 데이터, 레파지토리**
  
  + **응용 레이어 추가**
  
    RestaurantService를 따로 분리함으로써 코드 가독성을 증가시키고
  
    개발에 있어서 불필요하게 중복되는 코드들을 모듈화
  



​	JUnit4와 JUnit5 차이점

​		@Before -> @BeforeEach로 변경됨 : 각 테스트 메소드 실행 전에 실행되는 메소드 어노테이션

​		@BeforeAll은 모든 테스트 메소드 실행 전에 실행되는 어노테이션 -> static으로 해당 함수 지정해야함



## 환경

|    목록     |   종류   |
| :---------: | :------: |
| Spring Boot |  2.3.1   |
|     IDE     | IntelliJ |
|     DB      |  MySQL   |
|  Test Code  |  JUnit5  |

