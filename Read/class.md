# Class

## what is class? 
- object를 만드는 blueprint
- 클래스 이전에 object를 만드는 기본적인 방법은 funtion 
- javascript에도 class는 es6부터 가능
- OOP를 위한 초석
- typescript 에서는 클래스도 사용자가 만드는 타입의 하나
- js로 컴파일되면 es5 이전 버전의 경우 funtion으로 변경 es6이상부터 class 제공

```ts
class Person {
    name

    constructor(name: string) {
        this.name = name
    }
}

const p1 = new Person()

console.log(p1)
```

---

## constructor & initialization 
- 생성자 함수가 없으면, 디폴트 생성자가 불린다
- 생성자가 존재하면 디폴트 생성자는 존재하지않는다
- strict 모드에서는 property 선언하는곳 또는 생성자에서 값을 할당해야된다
- 프로퍼티를 선언하는 곳 또는 생성자에서 값을 할당하지 않는 경우에는 !를 붙여서 위험을 표현한다.
- property가 정의되어있지만 값을 대입하지않으면 undefined 
- 생성자에는 async 를 설정할 수 없다
```ts
class Person {
    name: string
    age: number
}

const p1 = new Person()

console.log(p1)
```

---

## Access Modifiers
- public 
- private 
- protected 
- 설정하지 않으면 public 
- 클래스 내부의 모든곳에서 생성자 프로퍼티 매서드 설정이 가능하다
- private 으로 설정하면 클래스 외부에서 접근이 불가능하다
- 자바스크립트에서 private를 지원하지 않아 오랫동안 프로퍼티나 메서드이름앞에 _를 붙여 표현

---

## getter & setter 
- getter 함수로 데이터 가져오기
- setter 함수로 데이터 입력

---

## readonly Property
- readonly 옵션을가지고 있으면 초기화할떄 값이정해지면 그이후에 값변경 불가 

---

## index signatures in class
- 데이터가 동적으로 할당될떄 유용한 방식

```ts
class Students {
     [index: string]: 'male' | 'female'
}

const a = new Students()
a.mark = 'male'
a.jade = 'male'

console.log(a)

const b = new Students()
b.chloe = 'female'
b.alex = 'male'
b.anna = 'female'

console.log(b)
```

---

## static Porperties & Methods
