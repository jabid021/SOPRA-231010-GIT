import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stagiaire } from '../model';

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Stagiaire[]> {
    return this.http.get<Stagiaire[]>("http://localhost:8080/api/stagiaire");
  }

  findById(id?: number): Observable<Stagiaire> {
    return this.http.get<Stagiaire>("http://localhost:8080/api/stagiaire/"+id);
  }

  create(stagiaire: Stagiaire): Observable<Stagiaire> {
    return this.http.post<Stagiaire>("http://localhost:8080/api/stagiaire", stagiaire);
  }

  update(stagiaire: Stagiaire): Observable<Stagiaire> {
    return this.http.put<Stagiaire>("http://localhost:8080/api/stagiaire/"+stagiaire.id, stagiaire);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>("http://localhost:8080/api/stagiaire/"+id);
  }
}
