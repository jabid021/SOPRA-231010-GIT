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
  todoForm: Todo = new Todo();
  recherche: string = "";

  todos: Todo[] = new Array<Todo>();

  constructor() {
    this.todos.push(new Todo(2, "faire la lessive", false));
    this.todos.push(new Todo(5, "Ranger chambre", true));
    this.todos.push(new Todo(7, "jeter le chat dehors", true));
  }

  resetPrenom() {
    this.prenom = this.prenom.toUpperCase();
  }

  changePrenom(evt : any) {
    this.prenom = evt.target.value;
  }

  modelChange(event: any) {
    this.prenom = event.toUpperCase();
  }

  addTodo() {
    this.todos.push(this.todoForm);
    this.todoForm = new Todo();
  }

  search(): Array<Todo>  {
    // if(this.recherche) {
      return this.todos.filter(item => item.title?.includes(this.recherche));
      // return this.todos.filter(item => item.title?.indexOf(this.recherche) != -1);
    // }

    // return this.todos;
  }
}
