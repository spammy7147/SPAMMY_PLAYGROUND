
# Interface 

```ts
interface person {
    name: string
    age: number
}

function hello(person: person): void {
    console.log(`안녕하세요! ${person.name}입니다`)
}

const p1: person = {
    name: "spammy",
    age: 39,
}

hello(p1)
```



## optional property
- 객체의 property가 있을수도 없을수도 있는 상황에서는 ? 를 붙여준다
   
    - ```ts
        interface Person2 {
            name: string
            age?: number
        }
        funtion hello2(person: Person2): void {
            console.log(`안녕하세요! ${person.name}입니다.`)
        }

        hello2({ name: "Mark" age: 39})
        hello2({ name: "Anna" })
        ``` 
- indexable property 
    - ```ts
        interface Person3 {
            name: string
            age?: number
            [index: string]: any
        }
        funtion hello3(person: Person3): void {
            console.log(`안녕하세요 ${person.name} 입니다.`)
        }

        const p31: Person3 = {
            name: "Mark",
            age: 39,
        }
        const p32: Person3 = {
            name: "Anna"
            systers: ["sung", "Chan"],
        }
        const p33: Person3 = {
            name: "bokdaengi"
            fater: p31,
            mother: p32,
        }
        ```
- 클래스에서 인터페이스 implements 하기 
    - ```ts
        interface Iperson1 {
            name: string
            age?: number
            hello(): void
        }
        class Person implements IPerson1 {
            name: string
            age?: number | undefined
        }
        constructor(name: string) {
            this.name = name
        }
        hello(): void {
            console.log(`안녕하세요 ${this.name} 입니다.`)
        }
        const person:IPerson1 = new Person("Mark")
        person.hello()
        ```

---

## interface extends interface

```ts
    interface Iperson2 {
        name: string
        age?: number
    }
    interface IKorean extends IPerson2 {
        city: string
    }
    const k: IKorean = {
        name: "이웅재"
        city: "서울"
    }
    // HTMLDivElement ==> interface extends 한 예제
```

---

## funtion interface 

```ts
interface HelloPerson {
    (name: string, age?: number): void
}
const helloPerson: HelloPerson = funtion (name: string, age?:number) {
    console.log(`안녕하세요! ${name} 입니다.`)
}
// const helloPerson: HelloPerson = funtion (name: string, age:number) {
//     console.log(`안녕하세요! ${name} 입니다.`)
/*
    error => interface 에서 age?: number 이라고 타입선언을했지만 
    함수 내부에서 age: number 로 설정해버렸기떄문에 
*/
```

---

## readonly Interface Properties 
```ts
    interface Person8 {
        name: string
        age?: number
        readonly gender: stringt
    }
    const p81: Person8 = {
        name: "mark"
        gender: "male"
    }
    // p81.gender = "female" => 오류 readonly 선언되어있는 property값을 재할당하려고 하기때문에 

```

---
## type alias vs interface
- funtion 
```ts
//type alias
type EatType = (food: string) => void

//interface
interface IEat {
    (food: string): void
}
```

- array
```ts
//type alias
type PersonList = string[]

//interface
interface IPersonList {
    [index: number]: string
}
```

- intersection 
```ts
interface ErrorHandling {
    success: boolean
    error?: {message: string}
}
interface ArtistsData{
    artists:{name: string}[]
}

//type alias 
type ArtistResponseType = ArtistsData & ErrorHandling

//interface
interface IArtistsResponse extends ArtistsData, ErrorHandling {}
}

let art:ArtistsResponseType
let iar: IArtistsResponse

```

- union type 
```ts
interface Bird {
    fly(): void
    layEggs(): void
}
interface Fish {
    swing():void
    layEggs():void
}

//type alias
type PetType = Bird | Fish 

interface IPet extends petType() {} // error ts2312 => interface can only extend an object type or intersection of object types with statically known memebers

class pet implements petType {} // error TS2422 => class can only implement an object type or intersection of object types with statically known members

```

- Decalrartion Merging - interface 
    - 이름이 같은 인터페이스 선언을 하면 호출할떄 자동 merging이 된다.
    - type alias에서는 merging이 불가능하다 => 같은 이름으로 선언을하면 중복된이름으로 선언되었다는 오류가 난다.
    - ```ts 
        interface MergingInterface {
            a: string
        }
        interface MergingInterface {
            b: string
        }
        let mi: MergingInterface
        ````