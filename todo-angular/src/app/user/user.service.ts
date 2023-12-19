import { Injectable } from '@angular/core';
import { User } from '../model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  users: User[] = new Array<User>();

  constructor() { 
    this.users.push(new User(3, "Eric", "SULTAN", "esultan", "123456"));
    this.users.push(new User(7, "Pierre", "LANGLADE", "planglade", "123456"));
    this.users.push(new User(8, "Vincent", "RIGOLOT", "vrigolot", "123456"));
  }

  findAll(): User[] {
    return this.users;
  }

  findById(id: number): User | undefined {
    return this.users.find(u => u.id == id);
  }

  save(user?: User) {
    if(user?.id) {
      let position = this.users.findIndex(u => u.id == user.id);

      this.users[position] = user;
    } else {
      let max: number = 0;
      this.users.forEach(u => {
        if(u.id && u.id > max) {
          max = u.id;
        }
      });

      user!.id = max+1;

      this.users.push(user!);
    }
  }

  delete(id: number) {
    let position = this.users.findIndex(u => u.id == id);

    this.users.splice(position, 1);
  }
}
