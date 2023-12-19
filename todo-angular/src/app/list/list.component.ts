import { Component } from '@angular/core';
import { List, User } from '../model';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {
  lists: List[] = new Array<List>();
  
  listForm?: List = undefined;


  constructor(private userService: UserService) {
    this.lists.push(new List(4, "Tâche ménagère", 3));
    this.lists.push(new List(5, "Liste de Noël", 3));
    this.lists.push(new List(7, "Liste de mariage", 8));
  }

  list(): List[] {
    return this.lists;
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
    this.listForm = {...this.lists.find(list => list.id == id)??undefined};
  }

  save() {
    if(this.listForm?.id) {
      let position = this.lists.findIndex(l => l.id == this.listForm?.id);

      this.lists[position] = this.listForm;
    } else {
      let max: number = 0;
      this.lists.forEach(l => {
        if(l.id && l.id > max) {
          max = l.id;
        }
      });

      this.listForm!.id = max+1;

      this.lists.push(this.listForm!);
    }

    this.cancel();
  }

  remove(id?: number) {
    let position = this.lists.findIndex(l => l.id == id);

    this.lists.splice(position,1);
  }

  cancel() {
    this.listForm = undefined;
  }

}
