
// boolean
let isDone: boolean = false

isDone = true

console.log(typeof isDone)

// let isOk: Boolean = true
// let isNotOk: boolean = new Boolean(true)



// number
let decimal: number = 6;
let hex: number = 0xf00d
let binary: number = 0b1010
let octal: number = 0o744
let notANumber: number = NaN
let underscoreNum: number = 1_000_000


// string 
let myName: string = 'Spammy'
let age: number = 38

// template string 사용
let sentence1: string = `Hello, my name is ${myName}. 
I'll be ${age + 1} years old next month.`

//template string 미사용
let sentence2: string = 'Hello, my name is' + myName + '.\n\n' + 
"I'll be" +  (age + 1) + 'years old next month.'


// Symbol

console.log(Symbol('foo') === Symbol('foo'))

const sym = Symbol()

const obj = {
    [sym]: 'value',
}

obj[sym]


// Undefined & Null

/*
- undefined & null 은 각각의 타입입니다 
- 그 자체로는 유용하지 않습니다.
- 소문자만 존재합니다.

- undefined & null 은 다른 타입의 서브 타입입니다. 
- 하지만 컴파일 옵션에서 `--strictNullChecks` 를 사용하면, 
    null & undefined은 void나 자기자신에게만 할당가능합니다
*/

// let myNameNull: string = null
let v: void = undefined
let union: string | null = null;

/*

null in JavaScript
- null 이라는 값으로 할당된 것을 null 이라고 합니다
- null 타입은 null 값만 가질 수 있습니다.
- typeof 연산자로 null 을 찍어보면 object 입니다.
- 존재는 하는데 사용준비가 덜 된 상태

*/

let n: null = null
console.log(n)          // null
console.log(typeof n)   // object


/*

undefined in JavaScript
- 값을 할당하지 않은 변수는 undefined라는 값을 가집니다
- object의 property가 없을때도 undefined 
- typeof 연산자로 undefined를 찍어보면 undefined 입니다
- 무언가가 아예 준비가 안된 상태

*/
let u: undefined = undefined
console.log(u)          // undefined
console.log(typeof u)   // undefined


// Object 

/*
- a type that represents the non-primitive type
- "primitive type 이 아닌것" 을 나타내고 싶을 때 사용하는 타입

non-primitive type
not {
    number, string, boolean, bigint, symbol, null, or undefined
}
*/

const person1 = {
    name: 'Spammy',
    age: 39
}

//person1 is not "object" type
// person1 is "{name: 'Spammy', age: 39}" type.

//create by Object.create
const person2 = Object.create({name: 'Spammy', age: 39})


// Array
/*
- array는 js에서 객체

사용법 
- Array<타입>
- 타입[]

*/

let list1: Array<number> = [1, 2, 3]
let list2: (number | string)[] = [1, 2, 3, '4']


// Tuple

let x: [string,number]

x = ['hello', 39]

// x = [10, 'mark'] //error

// x[2] //error

const p: [string, number] = ['spammy',39]
const [first, second] = p

/*
길이가 정해져있고 
자료형의 순서가 일정한 
*/


// Any

function returnAny(message: any): any {
    console.log(message)
}

const any1 = returnAny('리턴은 아무거나')
any1.toString()

/*
- 어떤 타입이어도 상관없는 타입
- 쓰지않는게 좋다 왜냐하면 컴타일 타임에 타입체크가 정상적으로 이루어지지 않기때문
- 컴파일 옵션중에 any를 써야야되는데 쓰지 않으면 오류를 뱉는 옵션도 있다.
- any는 계속해서 개체를 통해 전파된다
- 타입의 안정성을 잃는 대가로 이어진다
-  타입 안정성은 TypeScript를 사용하는 주요 이유중 하나이며 꼭 필요한 경우만 any를 사용한다.
*/

let looselyTyped: any= {}
let d = looselyTyped.a.b.c.d

function leakingAny(obj: any){
    const a: number = obj.num
    const b =  a + 1
    return b
}

const c = leakingAny({num: 0})
// c.indexOf('0')



// Unknown 
/*
- 응용 프로그램을 작성할 때 모르는 변수의 타입을 묘사해야 할 수도 있습니다.
- 이러한 값은 동적 콘텐츠(예: 사용자로부터, 또는 우리 API 의 모든 값을 의도적으로 수락하기를 원할 수 있습니다.)
- 이 경우, 컴파일러와 미래의 코드를 읽는 사람에게 이 변수가 무엇이든 될 수 있음을 알려주는 타입을 제공 하기를 원하므로 unknown타입을 제공합니다.
*/

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

//never 

function error(message: string): never {
    throw new Error(message)
}
function fail() {
    return error("failed")
}
function infiniteLoop(): never {
    while (true) {}
}

/*
- never 타입은 모든타입의 subtype 이며, 모든 타입에 할당 할 수 있습니다.
- 하지만 never 에는 어떤것도 할당할 수 없습니다.
- any 조차도 never 에게 할당 할 수 없습니다.
- 잘못된 타입을 넣는 실수를 막고자 할 때 사용하기도 합니다.
*/

let a: string = 'hello'
if (typeof a !== 'string') {
    let b: never = a
}

type Indexable<T> = T extends string ? T & {[index: string]: any} : never


//void 
/*
- 다른언어에서 void 타입을 사용하기떄문에 명시적으로 적용?
*/

function returnVoid(message: string) {
    console.log(message)

    return;
}

const r:void = returnVoid('리턴이 없다.') //r void