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