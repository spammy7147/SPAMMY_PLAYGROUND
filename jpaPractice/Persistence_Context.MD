
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
    
---

JPA Cascade (영속성 전이)

JPA OrphanRemoval 
- for orphan removal : If you invoke setOrder(null), the related Order entities will be removed in DB automoatically
- for remove cascade : If you invoke setOrder(null), the related Order entities will NOT be removed in DB automoatically

---

Embedded 
- Entity의 필드를 하나로 합쳐서 끼워넣는형식으로 사용한다. 
  - 예를들어 주소 같은경우는 시, 도, 군, 우편번호 이런식으로 나누어지는 경우가 많은데 
    그부분을 각각의 필드로 받아서 Entity에서 사용하면 필드도 많아지고 지저분해지는 
    경우가 발생한다. 그것을 Address 클래스를 embed로 사용해서 줄일 수 있다.
    

---

N + 1 이슈
- @EntityGraph
- @Query("select distinct r from Review r join fetch r.comments") : JPA query 

--- 

Dirty Check
- 영속성 관리중에 일어난 변경은  save 매서드가없어도 영속화 시켜주는 것.
- Insert 시에는 새로 생성된 엔티티가 영속화가 되지 않아서  더디체크의 대상이 아님
- @Transactional(readOnly = true) 을사용하면 
  session의 flush모델의 타입을 MANUAL로 변경되어 더디체크가 스킵된다.