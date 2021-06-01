# Type Compatibility

### sub type
```ts
//sub1 타입은 sup1 타입의 서브 타입
let sub1: 1 = 1
let sup1: number = sub1
sub1 = sup1  //error 
//sup1 이 더크기떄문에 sub1에 넣을 수 없다.
```
---

# Type Alies
- interface 랑 비슷해 보인다.
- pirimitive, union type, tuple, funtion 의 타입을 별칭으로 사용하는 방법
- 직접 작성해야하는 타입을 다른이름으로 지정
- 만들어진 타입의 refer로 사용하는 것

```ts
// aliasing primitive
type MyStringType = string
const str = 'world'
let myStr: MyStringType = 'hello'
myStr = str

//aliasing union type
let person: string | number = 0
person = 'spammy'

type StirngOrNumber = string | number
let another: StringOrNumber = 0
another = 'Anna'

//aliasing tuple
let person: [string, number] = ['mark', 35]
type PersonTuple = [string, number]
let another: PersonTuple = ['Anna', 24]

//aliasing function
type EatType = (food: string) => void
```
---

# Compliation Context
- compilation context is basically just a fancy term for grouping of the files that TypeScript will parse and analyze to determine what is valid and what is not
- Along with the information about which files, the compilation context contains information about which compiler options are in use
- A great way to define this logical grouping (we also like to use the term project) is using a tsconfig.json file

---

# tsconfig shcema
최상위 프로퍼티
- compileOnSave
- extends
- complieOptions
- files
- include
- exclude
- references
- typeAcquisition
- tsNode