import { Component } from '@angular/core';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  prenom: string = "Eric";
  couleur: string = "#FF0000";
  todo: Todo = new Todo();

  resetPrenom() {
    this.prenom = this.prenom.toUpperCase();
  }

  changePrenom(evt : any) {
    this.prenom = evt.target.value;
  }

  modelChange(event: any) {
    this.prenom = event.toUpperCase();
  }
}
