import { Component } from '@angular/core';
import { UtilisateurService } from './utilisateur.service';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent {
  userForm!: FormGroup;

  idCtrl!: FormControl;
  nomCtrl!: FormControl;
  prenomCtrl!: FormControl;
  usernameCtrl!: FormControl;
  passwordCtrl!: FormControl;

  showForm: boolean = false;

  utilisateurs$!: Observable<Utilisateur[]>;

  constructor(private userService: UtilisateurService, private formBuilder: FormBuilder) {
    this.load();
  }

  ngOnInit(): void {
    this.idCtrl = this.formBuilder.control('');
    this.nomCtrl = this.formBuilder.control('');
    this.prenomCtrl = this.formBuilder.control('');
    this.usernameCtrl = this.formBuilder.control('',Validators.required);
    this.passwordCtrl = this.formBuilder.control('');

    this.userForm = this.formBuilder.group( {
      id: this.idCtrl,
      nom: this.nomCtrl,
      prenom: this.prenomCtrl,
      username: this.usernameCtrl,
      password: this.passwordCtrl
    });
  }

  load() {
    this.utilisateurs$ = this.userService.findAll();
  }

  list() {
    return this.utilisateurs$;
  }

  add() {
    this.userForm.reset();
    this.showForm = true;
  }

  edit(id?: number) {
    this.userService.findById(id).subscribe(resp => {
      this.userForm.patchValue(resp);
      this.showForm = true;
    });
  }

  save() {
    this.userService.save(this.userForm.value).subscribe(resp => this.load());
    this.cancel();
  }

  remove(id?: number) {
    this.userService.delete(id).subscribe(resp => this.load());
  }

  cancel() {
    this.showForm = false;
    this.userForm.reset();
  }
}
