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