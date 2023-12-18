import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'todoState'
})
export class TodoStatePipe implements PipeTransform {

  transform(value: boolean, param?: string): string {
    if(param == "description") {
      return value ? "Terminé" : "Non terminé";
    }

    return value ? "hsl(153 48% 49%)" : "hsl(341 79% 53%)";
  }

}
