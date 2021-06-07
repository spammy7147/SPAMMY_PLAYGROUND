"use strict";
var _a;
// boolean
var isDone = false;
isDone = true;
console.log(typeof isDone);
// let isOk: Boolean = true
// let isNotOk: boolean = new Boolean(true)
// number
var decimal = 6;
var hex = 0xf00d;
var binary = 10;
var octal = 484;
var notANumber = NaN;
var underscoreNum = 1000000;
// string 
var myName = 'Spammy';
var age = 38;
// template string 사용
var sentence1 = "Hello, my name is " + myName + ". \nI'll be " + (age + 1) + " years old next month.";
//template string 미사용
var sentence2 = 'Hello, my name is' + myName + '.\n\n' +
    "I'll be" + (age + 1) + 'years old next month.';
// Symbol
console.log(Symbol('foo') === Symbol('foo'));
var sym = Symbol();
var obj = (_a = {},
    _a[sym] = 'value',
    _a);
obj[sym];
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
var v = undefined;
var union = null;
/*

null in JavaScript
- null 이라는 값으로 할당된 것을 null 이라고 합니다
- null 타입은 null 값만 가질 수 있습니다.
- typeof 연산자로 null 을 찍어보면 object 입니다.
- 존재는 하는데 사용준비가 덜 된 상태

*/
var n = null;
console.log(n); // null
console.log(typeof n); // object
/*

undefined in JavaScript
- 값을 할당하지 않은 변수는 undefined라는 값을 가집니다
- object의 property가 없을때도 undefined
- typeof 연산자로 undefined를 찍어보면 undefined 입니다
- 무언가가 아예 준비가 안된 상태

*/
var u = undefined;
console.log(u); // undefined
console.log(typeof u); // undefined
// Object 
/*
- a type that represents the non-primitive type
- "primitive type 이 아닌것" 을 나타내고 싶을 때 사용하는 타입

non-primitive type
not {
    number, string, boolean, bigint, symbol, null, or undefined
}
*/
var person1 = {
    name: 'Spammy',
    age: 39
};
//person1 is not "object" type
// person1 is "{name: 'Spammy', age: 39}" type.
//create by Object.create
var person2 = Object.create({ name: 'Spammy', age: 39 });
// Array
/*
- array는 js에서 객체

사용법
- Array<타입>
- 타입[]

*/
var list1 = [1, 2, 3];
var list2 = [1, 2, 3, '4'];
// Tuple
var x;
x = ['hello', 39];
// x = [10, 'mark'] //error
// x[2] //error
var p = ['spammy', 39];
var first = p[0], second = p[1];
/*
길이가 정해져있고
자료형의 순서가 일정한
*/
// Any
function returnAny(message) {
    console.log(message);
}
var any1 = returnAny('리턴은 아무거나');
any1.toString();
/*
- 어떤 타입이어도 상관없는 타입
- 쓰지않는게 좋다 왜냐하면 컴타일 타임에 타입체크가 정상적으로 이루어지지 않기때문
- 컴파일 옵션중에 any를 써야야되는데 쓰지 않으면 오류를 뱉는 옵션도 있다.
- any는 계속해서 개체를 통해 전파된다
- 타입의 안정성을 잃는 대가로 이어진다
-  타입 안정성은 TypeScript를 사용하는 주요 이유중 하나이며 꼭 필요한 경우만 any를 사용한다.
*/
var looselyTyped = {};
var d = looselyTyped.a.b.c.d;
function leakingAny(obj) {
    var a = obj.num;
    var b = a + 1;
    return b;
}
var c = leakingAny({ num: 0 });
// const aNumber: number = maybe 
// unknown type 인 maybe를 number 타입인 aNumber에 바로 할당 불가능
if (maybe === true) {
    var aBoolean = maybe;
    // const aString: string = maybe //error
}
if (typeof maybe === "string") {
    var aString = maybe;
}
if (typeof maybe === "number") {
    var aNumber = maybe;
}
//never 
function error(message) {
    throw new Error(message);
}
function fail() {
    return error("failed");
}
function infiniteLoop() {
    while (true) { }
}
/*
- never 타입은 모든타입의 subtype 이며, 모든 타입에 할당 할 수 있습니다.
- 하지만 never 에는 어떤것도 할당할 수 없습니다.
- any 조차도 never 에게 할당 할 수 없습니다.
- 잘못된 타입을 넣는 실수를 막고자 할 때 사용하기도 합니다.
*/
var a = 'hello';
if (typeof a !== 'string') {
    var b = a;
}
//void 
/*
- 다른언어에서 void 타입을 사용하기떄문에 명시적으로 적용?
*/
function returnVoid(message) {
    console.log(message);
    return;
}
var r = returnVoid('리턴이 없다.'); //r void
