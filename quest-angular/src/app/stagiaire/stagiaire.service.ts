import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stagiaire } from '../model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Stagiaire[]> {
    return this.http.get<Stagiaire[]>(environment.apiUrl + "/stagiaire");
  }

  findById(id?: number): Observable<Stagiaire> {
    return this.http.get<Stagiaire>(environment.apiUrl + "/stagiaire/"+id);
  }

  create(stagiaire: Stagiaire): Observable<Stagiaire> {
    return this.http.post<Stagiaire>(environment.apiUrl + "/stagiaire", stagiaire);
  }

  update(stagiaire: Stagiaire): Observable<Stagiaire> {
    return this.http.put<Stagiaire>(environment.apiUrl + "/stagiaire/"+stagiaire.id, stagiaire);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/stagiaire/"+id);
  }
}
