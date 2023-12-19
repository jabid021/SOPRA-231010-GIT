export class List {
    constructor(public id?: number, public name?: string, public userId?: number) {

    }
}

export class User {
    constructor(public id?: number, public firstname?: string, public lastname?: string, public login?: string, public password?: string) {

    }
}

export class Todo {
    constructor(public id?: number, public description?: string, public isImportant?: boolean, public isDone?: boolean, public listId?: number) {

    }
}