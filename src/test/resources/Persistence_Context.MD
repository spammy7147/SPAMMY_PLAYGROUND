
# Persistence Context


EntityManager
- Resources 하위에 META-INF 내부에 persistence.xml 생성
- xml을 로딩해서 영속성 컨텍스트를 로딩해서 사용합니다.
- JPA의존성을 추가했기떄문에 부트에서 제공하는 기본 JPA설정을 사용합니다.
- hybernate 에서는 EntityManger를 Session이라 부릅니다. 
  (session에서 EntityManager를 상속받아 사용)
- 1차 cache 는 map형태로 <id, entity>로 묶여있으며 id로 검색할시 작동한다. ****

Transaction
- ACID 
  - ALL OR NOTHING
  - Consistency
  - Isolation 
  - Durability 

