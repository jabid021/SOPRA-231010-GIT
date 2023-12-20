import { Injectable } from '@angular/core';
import { Matiere } from '../model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  matieres: Array<Matiere> = new Array<Matiere>();

  constructor(private http: HttpClient) {
    this.load();
  }

  load() {
    let obs: Observable<Matiere[]> = this.http.get<Matiere[]>("http://localhost:8080/api/matiere");

    obs.subscribe(retour => {
      this.matieres = retour;
    });
  }

  findAll(): Matiere[] {
    return this.matieres;
  }

  findById(id?: number): Observable<Matiere> {
    return this.http.get<Matiere>("http://localhost:8080/api/matiere/"+id);
  }

  create(matiere: Matiere): void {
    this.http.post<Matiere>("http://localhost:8080/api/matiere", matiere).subscribe(resp => {
      this.load();
    });
  }

  update(matiere: Matiere): void {
    this.http.put<Matiere>("http://localhost:8080/api/matiere/"+matiere.id, matiere).subscribe(resp => {
      this.load();
    });
  }

  delete(id?: number) {
    this.http.delete<void>("http://localhost:8080/api/matiere/"+id).subscribe(resp => {
      this.load();
    });
  }
}
