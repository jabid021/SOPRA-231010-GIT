import { Injectable } from '@angular/core';
import { List, User } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  lists: List[] = new Array<List>();

  constructor() { 
    this.lists.push(new List(4, "Tâche ménagère", 3));
    this.lists.push(new List(5, "Liste de Noël", 3));
    this.lists.push(new List(7, "Liste de mariage", 8));
  }

  findAll(): List[] {
    return this.lists;
  }

  findById(id: any): List | undefined {
    return this.lists.find(l => l.id == id);
  }

  save(list?: List) {
    if(list?.id) {
      let position = this.lists.findIndex(l => l.id == list.id);

      this.lists[position] = list;
    } else {
      let max: number = 0;
      this.lists.forEach(l => {
        if(l.id && l.id > max) {
          max = l.id;
        }
      });

      list!.id = max+1;

      this.lists.push(list!);
    }
  }

  delete(id: number) {
    let position = this.lists.findIndex(l => l.id == id);

    this.lists.splice(position, 1);
  }
}
