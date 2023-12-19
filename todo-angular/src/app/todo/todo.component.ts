import { Component } from '@angular/core';
import { Todo } from '../model';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent {
  todos: Todo[] = new Array<Todo>();
  
  constructor() {
    this.todos.push(new Todo(5, "Ménage", true, false, 4));
    this.todos.push(new Todo(50, "Vaisselle", false, true, 4));
    this.todos.push(new Todo(15, "Repassage", true, false, 4));
  }
}
