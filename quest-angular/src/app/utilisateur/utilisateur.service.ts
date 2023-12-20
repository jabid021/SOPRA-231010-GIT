import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(environment.apiUrl + "/utilisateur");
  }

  findById(id?: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(environment.apiUrl + "/utilisateur/"+id);
  }

  save(utilisateur: Utilisateur): Observable<Utilisateur> {
    if(utilisateur.id) {
      return this.http.put<Utilisateur>(environment.apiUrl + "/utilisateur/"+utilisateur.id, utilisateur);
    }

    return this.http.post<Utilisateur>(environment.apiUrl + "/utilisateur", utilisateur);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/utilisateur/"+id);
  }
}
