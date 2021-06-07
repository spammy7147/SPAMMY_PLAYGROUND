// generic with extends

class PersonExtends<T extends string | number> {
    private _name: T

    constructor(name: T) {
        this._name = name
    }
}

new PersonExtends("Spammy")
new PersonExtends(39)
new PersonExtends(true)