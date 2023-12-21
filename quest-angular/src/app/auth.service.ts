import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from './model';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private utilisateur?: Utilisateur = undefined;

  constructor(private http: HttpClient, private router: Router) { }

  login(username: string, password: string) {
    return this.http.post<Utilisateur>(environment.apiUrl + `/connexion`, { "login": username, "password": password }).subscribe(resp => {
      this.utilisateur = resp;
      localStorage.setItem("user", JSON.stringify(this.utilisateur));

      this.router.navigate(["/accueil"]);
    });
  }

  logout() {
    this.utilisateur = undefined;
    localStorage.removeItem("user");
  }

  isLogged(): boolean {
    return this.getUtilisateur() != undefined;
  }

  getUtilisateur(): Utilisateur | undefined{
    if(this.utilisateur) {
      return this.utilisateur;
    } else {
      const user = localStorage.getItem("user")
      if(user) {
        this.utilisateur = JSON.parse(user);
        return this.utilisateur;
      }
    }

    return undefined;
  }
}
