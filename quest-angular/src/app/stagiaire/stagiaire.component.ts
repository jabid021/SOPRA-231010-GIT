import { Component } from '@angular/core';
import { Stagiaire } from '../model';
import { Observable } from 'rxjs';
import { StagiaireService } from './stagiaire.service';

@Component({
  selector: 'app-stagiaire',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.css']
})
export class StagiaireComponent {
  stagiaireForm?: Stagiaire = undefined;

  stagiaires$!: Observable<Stagiaire[]> 

  constructor(private stagiaireService: StagiaireService) {
    this.load();
  }

  load() {
    this.stagiaires$ = this.stagiaireService.findAll();
  }

  list(): Observable<Stagiaire[]> {
    return this.stagiaires$;
  }

  add() {
    this.stagiaireForm = new Stagiaire();
  }

  edit(id?: number) {
    this.stagiaireService.findById(id).subscribe(resp => {
      this.stagiaireForm = resp;
    });
  }

  save() {
    if(this.stagiaireForm) {
      if(this.stagiaireForm.id) {
        this.stagiaireService.update(this.stagiaireForm).subscribe(resp => {
          this.load();
        });
      } else {
        this.stagiaireService.create(this.stagiaireForm).subscribe(resp => {
          this.load();
        });
      }
    }

    this.cancel();
  }

  remove(id?: number) {
    this.stagiaireService.delete(id).subscribe(() => {
      this.load();
    });
  }

  cancel() {
    this.stagiaireForm = undefined;
  }
}
