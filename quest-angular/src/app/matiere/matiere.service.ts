import { Injectable } from '@angular/core';
import { Matiere } from '../model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  matieres: Array<Matiere> = new Array<Matiere>();

  constructor(private http: HttpClient) {
    this.load();
  }

  load() {
    let obs: Observable<Matiere[]> = this.http.get<Matiere[]>(environment.apiUrl + "/matiere");

    obs.subscribe(retour => {
      this.matieres = retour;
    });
  }

  findAll(): Matiere[] {
    return this.matieres;
  }

  findById(id?: number): Observable<Matiere> {
    return this.http.get<Matiere>(environment.apiUrl + "/matiere/"+id);
  }

  create(matiere: Matiere): void {
    this.http.post<Matiere>(environment.apiUrl + "/matiere", matiere).subscribe(resp => {
      this.load();
    });
  }

  update(matiere: Matiere): void {
    this.http.put<Matiere>(environment.apiUrl + "/matiere/"+matiere.id, matiere).subscribe(resp => {
      this.load();
    });
  }

  delete(id?: number) {
    this.http.delete<void>(environment.apiUrl + "/matiere/"+id).subscribe(resp => {
      this.load();
    });
  }
}
