import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'check'
})
export class CheckPipe implements PipeTransform {

  transform(value?: boolean): string {
    if(value) {
      return "Oui";
    }

    return "Non";
  }

}
