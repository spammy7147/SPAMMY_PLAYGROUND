
# Type


## primitive type

- boolean
- number
- string
- symbol (ES2015)
- null 
- undefined

<br/><br/>

### literal 값으로 primitive 타입의 서브 타입을 나타낼 수 있다  
```ts
true
'hello'
3.14
null
undefined
```

<br/><br/>

### 래퍼 객체로 만들 수 있다
```ts
new Boolean(false)
new String('world')
new Number(42)
```

### 주의할점 
- TypeScript의 핵심 primitive type은 모두 소문자  
- Boolean, String, Number 같은 type은 소문자의 primitive type과 다르다.
- 래퍼 객체로 사용할시 primitives를 나타내지 않으며 타입으로 사용해서는 안된다.


---

## Number / number
- JavaScrpt 와 같이, TypeScript의 모든 숫자는 부동 소수점 값 입니다.
- TypeScript는 16진수 및 10진수 리터럴 외에도,  ECMAScript 2015에 도입된 2진수 및 8진수를 지원합니다.
- NaN
- 1_000_000과 같은 표기 가능

```ts
let decimal: number = 6;
let hex: number = 0xf00d
let binary: number = 0b1010
let octal: number = 0o744
let notANumber: number = NaN
let underscoreNum: number = 1_000_000
```

---

## Template String
- 행에 걸쳐 있거나, 표현식을 넣을 수 있는 문자열
- 이 문자열은 backtick (=backquote) 기호에 둘러쌓여 있습니다.
- 포함된 표현식은 `${expr}` 와 같은 형태로 사용합니다.

```ts
// string 
let myName: string = 'Spammy'
let age: number = 38

// template string 사용
let sentence1: string = `Hello, my name is ${myName}. 
I'll be ${age + 1} years old next month.`

//template string 미사용
let sentence2: string = 'Hello, my name is' + myName + '.\n\n' + 
"I'll be" +  (age + 1) + 'years old next month.'

``` 

---

## Symbol 
- 프리미티브 타입의 값을 담아서 사용합니다
- 고유하고 수정 불가능한 값으로 만들어줍니다.
- 접근을 제어하는데 쓰는 경우가 많다.

```ts 
const sym = Symbol()

const obj = {
    sym: 'value',
}

obj[sym]
```

---

## null in JavaScript
- null 이라는 값으로 할당된 것을 null 이라고 합니다
- null 타입은 null 값만 가질 수 있습니다.
- typeof 연산자로 null 을 찍어보면 object 입니다.
- 존재는 하는데 사용준비가 덜 된 상태

```ts
let n: null = null
console.log(n)          // null
console.log(typeof n)   // object
```

---

## undefined in JavaScript
- 값을 할당하지 않은 변수는 undefined라는 값을 가집니다
- object의 property가 없을때도 undefined 
- typeof 연산자로 undefined를 찍어보면 undefined 입니다
- 무언가가 아예 준비가 안된 상태

```ts
let u: undefined = undefined
console.log(u)          // undefined
console.log(typeof u)   // undefined
```

---

## Object 


- a type that represents the non-primitive type
- "primitive type 이 아닌것" 을 나타내고 싶을 때 사용하는 타입
- non-primitive type


```ts
const person1 = {
    name: 'Spammy',
    age: 39
}
//person1 is not "object" type
// person1 is "{name: 'Spammy', age: 39}" type.

//create by Object.create
const person2 = Object.create({name: 'Spammy', age: 39})
```

---

## Array

- array는 js에서 객체
- 사용법 
    - Array<타입>
    - 타입[]
   
```ts
let list1: Array<number> = [1, 2, 3]
let list2: (number)[] = [1, 2, 3]
let list3: (number | string)[] = [1, 2, 3, '4']
```

---

## Tuple

- 길이가 정해져있고 
- 자료형의 순서가 일정한 

```ts
let x: [string,number]

x = ['hello', 39]

// x = [10, 'mark'] //error

// x[2] //error

const p: [string, number] = ['spammy',39]
const [first, second] = p
```

---

## Any

- 어떤 타입이어도 상관없는 타입
- 쓰지않는게 좋다 왜냐하면 컴타일 타임에 타입체크가 정상적으로 이루어지지 않기때문
- 컴파일 옵션중에 any를 써야야되는데 쓰지 않으면 오류를 뱉는 옵션도 있다.
- any는 계속해서 개체를 통해 전파된다
- 타입의 안정성을 잃는 대가로 이어진다
-  타입 안정성은 TypeScript를 사용하는 주요 이유중 하나이며 꼭 필요한 경우만 any를 사용한다.


```ts
function returnAny(message: any): any {
    console.log(message)
}
const any1 = returnAny('리턴은 아무거나')
any1.toString()

/////////////////////////////

let looselyTyped: any= {}
let d = looselyTyped.a.b.c.d

function leakingAny(obj: any){
    const a: number = obj.num
    const b =  a + 1
    return b
}

const c = leakingAny({num: 0})
// c.indexOf('0')
```

---

## Unknown
- 응용 프로그램을 작성할 때 모르는 변수의 타입을 묘사해야 할 수도 있습니다.
- 이러한 값은 동적 콘텐츠(예: 사용자로부터, 또는 우리 API 의 모든 값을 의도적으로 수락하기를 원할 수 있습니다.)
- 이 경우, 컴파일러와 미래의 코드를 읽는 사람에게 이 변수가 무엇이든 될 수 있음을 알려주는 타입을 제공 하기를 원하므로 unknown타입을 제공합니다.

- TypeScript 3.0 버전부터 지원 
- any와 짝으로 any보다 Type-safe한 타입
    - any와 같이 아무거나 할당할 수 있다.
    - 컴파일러가 타입을 추론할 수 있게끔 타입의 유형을 좁히거나
    - 타입을 확정해주지 않으면 다른 곳에 할당 할 수 없고, 사용할 수 없다
- unknown 타입을 사용하면 runtime error를 줄일 수 있을 것 같다.
    - 사용 전에 데이터의 일부 유형의 검사를 수행해야 함을 알리는 API에 사용할 수 있을 것 같다.

```ts
declare const maybe: unknown
// const aNumber: number = maybe 
// unknown type 인 maybe를 number 타입인 aNumber에 바로 할당 불가능

if (maybe === true) {
    const aBoolean: boolean = maybe
    // const aString: string = maybe //error
}

if (typeof maybe === "string") {
    const aString: string = maybe
}

if (typeof maybe === "number") {
    const aNumber: number = maybe 
}
```

---

## never 

- never 타입은 모든타입의 subtype 이며, 모든 타입에 할당 할 수 있습니다.
- 하지만 never 에는 어떤것도 할당할 수 없습니다.
- any 조차도 never 에게 할당 할 수 없습니다.
- 잘못된 타입을 넣는 실수를 막고자 할 때 사용하기도 합니다.

```ts
function error(message: string): never {
    throw new Error(message)
}
function fail() {
    return error("failed")
}
function infiniteLoop(): never {
    while (true) {}
}

///////////////////////////

let a: string = 'hello'
if (typeof a !== 'string') {
    let b: never = a
}


type Indexable<T> = T extends string ? T & {[index: string]: any} : never
```

---

## void 
- 다른언어에서 void 타입을 사용하기떄문에 명시적으로 적용?

```ts
function returnVoid(message: string) {
    console.log(message)

    return;
}

const r:void = returnVoid('리턴이 없다.') //r void
```