import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { User } from '../model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  userForm?: User = undefined;

  constructor(private userService: UserService) {
      }

  list() {
    return this.userService.findAll();
  }

  add() {
    this.userForm = new User();
  }

  edit(id?: number) {
    this.userForm = {...this.userService.findById(id!)};
  }

  save() {
    this.userService.save(this.userForm);
    this.cancel();
  }

  remove(id?: number) {
    this.userService.delete(id!);
  }

  cancel() {
    this.userForm = undefined;
  }
}
