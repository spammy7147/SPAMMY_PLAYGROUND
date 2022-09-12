

# Type System

### structual type system 
- 구조가 같으면, 같은 타입이다.
- TypeScrpit는 structual type system 이다 

```ts
interface Iperson {
    name: string
    age: number
    speak(): string
}

type PersonType = {
    name: string
    age: number
    speak(): string
}

let personInerface: Iperson = {} as any
let personType: personType = {} as any

personInterface = personType
personType = personInerface

//구조가 같기떄문에 다른이름의 타입이라도 같은 타입
``` 
--- 

### nominal type system 
- 구조가 같아도 이름이 다르면, 다른 타입이다.
- TypeScrpit는 nominal type system 이 아니다. 

--- 

### duck typing
- 어떤 새가 오리처럼 걷고, 헤엄치고, 꽥꽥거리는 소리를 낸다면 나는 그 새를 오리라고 부를것이다. 
- python 이 duck typing system 