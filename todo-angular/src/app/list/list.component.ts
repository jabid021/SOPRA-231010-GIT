import { Component } from '@angular/core';
import { List } from '../model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {
  lists: List[] = new Array<List>();
  
  listForm?: List = undefined;


  constructor() {
    this.lists.push(new List(4, "Tâche ménagère", 3));
    this.lists.push(new List(5, "Liste de Noël", 3));
    this.lists.push(new List(7, "Liste de mariage", 8));
  }

  list(): List[] {
    return this.lists;
  }

  add() {
    this.listForm = new List();
  }

  edit(id?: number) {
    this.listForm = {...this.lists.find(list => list.id == id)??undefined};
  }

  save() {
    
  }

  remove(id?: number) {
    
  }

  cancel() {
    this.listForm = undefined;
  }

}
