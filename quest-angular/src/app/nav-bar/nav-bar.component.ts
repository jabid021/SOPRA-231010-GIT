import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
  constructor(private authService: AuthService) {

  }

  logout() {
    this.authService.logout();
  }

  isLogged(): boolean {
     return this.authService.isLogged();
  }

  showUtilisateur(): string {
    const utilisateur = this.authService.getUtilisateur();
    if(utilisateur) {
      return utilisateur.username + ": " + utilisateur.roles;
    }

    return "";
  }
}
