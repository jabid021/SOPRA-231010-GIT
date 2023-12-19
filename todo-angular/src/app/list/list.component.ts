import { Component } from '@angular/core';
import { List, User } from '../model';
import { UserService } from '../user/user.service';
import { ListService } from './list.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {
  listForm?: List = undefined;


  constructor(private userService: UserService, private listService: ListService) {
  }

  list(): List[] {
    return this.listService.findAll();
  }

  listUsers(): User[] {
    return this.userService.findAll();
  }

  findUserById(id?: number): User | undefined{
    return this.userService.findById(id!);
  }

  add() {
    this.listForm = new List();
  }

  edit(id?: number) {
    this.listForm = {...this.listService.findById(id!)};
  }

  save() {
    this.listService.save(this.listForm);

    this.cancel();
  }

  remove(id?: number) {
    this.listService.delete(id!);
  }

  cancel() {
    this.listForm = undefined;
  }

}
