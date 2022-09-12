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