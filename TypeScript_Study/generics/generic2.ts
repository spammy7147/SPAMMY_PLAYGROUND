function helloBasic<T, U>(message: T, comment: U): T {
    return message
}

helloBasic<string, number>("Spammy", 39)
helloBasic(36, 39)

