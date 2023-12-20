import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { MatiereComponent } from './matiere/matiere.component';
import { FiliereComponent } from './filiere/filiere.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [{path: "accueil", component: HomeComponent},
{path: "stagiaire", component: StagiaireComponent, canActivate: [AuthGuard]},
{path: "matiere", component: MatiereComponent, canActivate: [AuthGuard]},
{path: "filiere", component: FiliereComponent, canActivate: [AuthGuard]},
{path: "utilisateur", component: UtilisateurComponent, canActivate: [AuthGuard]},
{path: "login", component: LoginComponent},
{path: "", pathMatch: "full", redirectTo: "accueil"}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
