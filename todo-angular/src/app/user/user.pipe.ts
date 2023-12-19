import { Pipe, PipeTransform } from '@angular/core';
import { UserService } from './user.service';
import { User } from '../model';

@Pipe({
  name: 'user'
})
export class UserPipe implements PipeTransform {

  constructor(private userService: UserService) {
    
  }

  transform(value: number): User | undefined{
    return this.userService.findById(value);
  }

}
