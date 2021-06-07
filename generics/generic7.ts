// keyof & type lookup system 

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