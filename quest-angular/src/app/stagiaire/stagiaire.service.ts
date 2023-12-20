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
}
