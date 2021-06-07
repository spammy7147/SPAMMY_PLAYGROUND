# Generic 

### Any 와 generic 의 차이점 
- any타입은 너무  광범위한 타입이기때문에 의도되지않는 에러를 발생시킬 수 있다.

```ts
function helloString(message: string) {
    return message
}

function helloNumber(message: number): number {
    return message
}


// 비슷한 기능의 함수들이 반복

function hello(message: any): any {
    return message
}

console.log(hello("Spammy").length)
console.log(hello(39).length)

function helloGeneric<T>(message: T): T {
    return message
}

console.log(helloGeneric("Spammy").length)
console.log(helloGeneric(39))
console.log(helloGeneric(true))
```

---

### Basic 
generic 사용의 예시 

```ts
function helloBasic<T, U>(message: T, comment: U): T {
    return message
}

helloBasic<string, number>("Spammy", 39)
helloBasic(36, 39)
```

---

### Array와 Tuple 에서의 generic 
- array 내부의 값의 타입을 얻어와 유니온타입으로 묶어준다
- Tuple은 딱지정한 타입의 갯수만큼 가질 수 있다.

```ts
function helloArray<T>(message: T[]): T {
    return message[0]
}

helloArray(["hello", "World"])
helloArray(["hello", 5])


function helloTuple<T,K> (message: [T, K]): T {
    return message[0]
}

helloTuple(["hello", "World"])
helloTuple(["hello", 5])
```

---

### Generic funtion
```ts
type HelloFuntionGeneric1 = <T>(message: T) => T;


const HelloFuntion1: HelloFuntionGeneric1 = <T>(message: T): T => {
    return message
}

interface HelloFuntionGeneric2 {
    <T>(message: T): T
}

const helloFunction2: HelloFuntionGeneric2 = <T>(message: T): T => {
    return message
}
```

---

### generic class

```ts
class Person<T, K> {
    private _name: T
    private _age: K
    constructor(name: T, age: K) {
        this._name = name
        this._age = age
    }
}

new Person("Spammy",39)
new Person<string,number> ("Spammy", 39)
```

---

### generic extends 
```ts
class PersonExtends<T extends string | number> {
    private _name: T

    constructor(name: T) {
        this._name = name
    }
}

new PersonExtends("Spammy")
new PersonExtends(39)
// new PersonExtends(true) => error
```

---

### keyof & type lookup system

```ts
interface IPerson { 
    name: string
    age: number
}


const person: IPerson = {
    name: "Spammy",
    age: 39,
}

function getProp<T, K extends keyof T>(obj: T, key: K): T[K] {
    return obj[key]
}

getProp(person, 'age')

function setProp<T, K extends keyof T>(obj: T, key: K, value: T[K]): void {
    obj[key] = value
}

setProp(person, "name", "Anna")
```