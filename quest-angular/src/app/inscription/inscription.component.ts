import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { UtilisateurService } from '../utilisateur/utilisateur.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit{
  inscriptionForm!: FormGroup;

  nomCtrl!: FormControl;
  prenomCtrl!: FormControl;
  emailCtrl!: FormControl;
  usernameCtrl!: FormControl;
  passwordCtrl!: FormControl;

  constructor(private utilisateurService: UtilisateurService, private formBuilder: FormBuilder, private router: Router) {

  }

  ngOnInit(): void {
    this.nomCtrl = this.formBuilder.control("", Validators.required);
    this.prenomCtrl = this.formBuilder.control("");
    this.emailCtrl = this.formBuilder.control("");
    this.usernameCtrl = this.formBuilder.control("", Validators.required);
    this.passwordCtrl = this.formBuilder.control("", [Validators.required, Validators.minLength(5)]);

    this.inscriptionForm = this.formBuilder.group({
      nom: this.nomCtrl,
      prenom: this.prenomCtrl,
      email: this.emailCtrl,
      username: this.usernameCtrl,
      password: this.passwordCtrl
    });
  }

  inscription() {
    this.utilisateurService.inscription(this.inscriptionForm.value).subscribe(() =>
      this.router.navigate(['/login'])
    );
  }
}
