import { Component } from '@angular/core';
import { Matiere } from '../model';
import { Observable } from 'rxjs';
import { MatiereService } from './matiere.service';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.css']
})
export class MatiereComponent {
  matiereForm?: Matiere = undefined;

  constructor(private matiereService: MatiereService) {
  }

  list(): Matiere[] {
    return this.matiereService.findAll();
  }

  add() {
    this.matiereForm = new Matiere();
  }

  edit(id?: number) {
    this.matiereService.findById(id).subscribe(resp => {
      this.matiereForm = resp;
    });
  }

  save() {
    if(this.matiereForm) {
      if(this.matiereForm.id) {
        this.matiereService.update(this.matiereForm);
      } else {
        this.matiereService.create(this.matiereForm);
      }
    }

    this.cancel();
  }

  remove(id?: number) {
   this.matiereService.delete(id);
  }

  cancel() {
    this.matiereForm = undefined;
  }
}
