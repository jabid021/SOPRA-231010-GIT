import { Component } from '@angular/core';
import { List, Todo } from '../model';
import { TodoService } from './todo.service';
import { ListService } from '../list/list.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css'],
})
export class TodoComponent {
  todoForm?: Todo = undefined;
  
  constructor(private todoService: TodoService, private listService: ListService) {
  }

  list(): Todo[] {
    return this.todoService.findAll();
  }

  listLists(): List[] {
    return this.listService.findAll();
  }

  findListById(id: any): List | undefined{
    return this.listService.findById(id);
  }

  add() {
    this.todoForm = new Todo();
  }

  edit(id?: number) {
    this.todoForm = {...this.todoService.findById(id!)};
  }

  save() {
    this.todoService.save(this.todoForm);

    this.cancel();
  }

  remove(id?: number) {
    this.todoService.delete(id!);
  }

  cancel() {
    this.todoForm = undefined;
  }
}
