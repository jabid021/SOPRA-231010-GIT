import { Component } from '@angular/core';
import { Todo } from '../model';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent {
  todos: Todo[] = new Array<Todo>();

  todoForm: Todo | null = null;
  
  constructor() {
    this.todos.push(new Todo(5, "Ménage", true, false, 4));
    this.todos.push(new Todo(50, "Vaisselle", false, true, 4));
    this.todos.push(new Todo(15, "Repassage", true, false, 4));
  }

  add() {
    this.todoForm = new Todo();
  }

  edit(id?: number) {
    for(let todo of this.todos) {
      if(todo.id == id) {
        this.todoForm = todo;
        break;    
      }
    }
  }

  cancel() {
    this.todoForm = null;
  }
}
