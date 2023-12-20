import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { MatiereComponent } from './matiere/matiere.component';
import { FiliereComponent } from './filiere/filiere.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';

const routes: Routes = [{path: "accueil", component: HomeComponent},
{path: "stagiaire", component: StagiaireComponent},
{path: "matiere", component: MatiereComponent},
{path: "filiere", component: FiliereComponent},
{path: "utlisateur", component: UtilisateurComponent},
{path: "", pathMatch: "full", redirectTo: "accueil"}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
