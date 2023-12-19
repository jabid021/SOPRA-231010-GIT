import { Component } from '@angular/core';
import { Todo } from '../model';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent {
  todos: Todo[] = new Array<Todo>();

  todoForm?: Todo = undefined;
  
  constructor() {
    this.todos.push(new Todo(5, "Ménage", true, false, 4));
    this.todos.push(new Todo(50, "Vaisselle", false, true, 4));
    this.todos.push(new Todo(15, "Repassage", true, false, 4));
  }

  list(): Todo[] {
    return this.todos;
  }

  add() {
    this.todoForm = new Todo();
  }

  edit(id?: number) {
    for(let todo of this.todos) {
      if(todo.id == id) {
        this.todoForm = {...todo};
        break;    
      }
    }
  }

  save() {
    if(this.todoForm?.id) {
      let position = this.todos.findIndex(todo => todo.id == this.todoForm?.id);

      this.todos[position] = this.todoForm;
    } else {
      let max: number = 0;
      this.todos.forEach(todo => {
        if(todo.id && todo.id > max) {
          max = todo.id;
        }
      });

      this.todoForm!.id = max+1;

      this.todos.push(this.todoForm!);
    }

    this.cancel();
  }

  remove(id?: number) {
    let position = this.todos.findIndex(todo => todo.id == id);

    this.todos.splice(position,1);
  }

  cancel() {
    this.todoForm = undefined;
  }
}
