export class Matiere {
    constructor(public id?: number, public libelle?: string, public quest?: number) {

    }
}

export class Stagiaire {
    constructor(public id?: number, public nom?: string, public prenom?: string, public email?: string) {

    }
}

export class FiliereResponse {
    
}

export class Utilisateur {
    constructor(public id?: number, public version?: number, public username?: string, public password?: string, public nom?: string, public prenom?: string, public disabled?: boolean, public roles?: string[]) {

    }
}