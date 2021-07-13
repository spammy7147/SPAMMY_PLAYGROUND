
# Persistence Context


EntityManager
- Resources 하위에 META-INF 내부에 persistence.xml 생성
- xml을 로딩해서 영속성 컨텍스트를 로딩해서 사용합니다.
- JPA의존성을 추가했기떄문에 부트에서 제공하는 기본 JPA설정을 사용합니다.
- hybernate 에서는 EntityManger를 Session이라 부릅니다. 
  (session에서 EntityManager를 상속받아 사용)
- 1차 cache 는 map형태로 <id, entity>로 묶여있으며 id로 검색할시 작동한다. ****

---

Transaction
- ACID 
  - ALL OR NOTHING
  - Consistency
  - Isolation 
  - Durability 

---

TransactionalAspectSupport 
- invokeWithinTransation
- RuntimeException, Error 인경우 Roleback 작동
- Checked Exception은 롤백을 하지않는다. 
  - @Transactional(rolebackFor=Exception.class) 이런식으로 예외를 처리해주면 롤백이 진행


- @Transactional(isolation = Isolation.READ_UNCOMMITTED)
  - 커밋되지않는 정보들도 읽어온다. 만약 가져온정보를 저장해서 재사용하면 rollback을 했더라도 가져온 entity에 변경사항이 저장되어서
  의도되지않는 데이터 변경이 일어난다. 이것을 해결하고자 Entity에 @DynamicUpdate 를 사용하여 변경하고자하는 부분만 update쿼리를 날려 제어한다.


- UnrepeatableRead 상태
  - transaction 내부에서 계속적으로 조회되는값이 변경되는 현상
  - @Transactional(isolation = Isolation.REPEATABLE_READ)
  - transaction이 시작될떄의 정보를 스냅샷으로 들고있고 다른곳에서 정보의 변경이 있어도 변경된 정보를 가져오는것이 아닌 지금 이 transaction이 시작될떄의 상태를 그대로 읽어온다.


-  Phantom READ 상태가 발생 할 수 있다.
  - @Transactional(isolation = Isolation.SERIALIZABLE) 로 막아준다.
  - 다른transaction에서 데이터의 변경이 일어났다면 commit되기까지 기달렸다가 
    변경된 데이터의 값을 받아서 처리한다. 의도되지않게 데이터의 변경을 막아주지만 
    기달리는 시간이 길수도있기때문에 성능의 저하가 일어날 수 있다.
    
---

Propagation
- default => required : 기존의 사용하던 transaction 이 있으면 그것을 사용하고 없으면 새로운 transaction을 만든다.
    - 기본으로 제공하는  save() 함수는 required로 되어있다.
- supports 
    - transaction 이 있으면 사용하고 없으면 없는대로 진행
- not supported 
    - transaction 이 있으면 transaction을 중지하고 실행 후 다시 transaction을 이어 나간다.
- mandatory
    - 필수적으로 transaction이 필요합니다. 없으면 오류
- never 
    - transaction이 없어야됩니다. 있으면 오류 
    
---

Transactional 은 Method & Class 양쪽다 선언할 수 있고 
Method에서 선언된 transactional  어노테이션이 먼저 적용됩니다. 
    
