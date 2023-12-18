import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'monFiltre'
})
export class MonFiltrePipe implements PipeTransform {

  transform(value?: string, arg?:string): string {
    if(value) {
      
      if(arg && arg == "full") {
        let items: string[] = value.split(" ");
        
        for(let idx in items) {         
          let item = items[idx].charAt(0).toUpperCase() + items[idx].substring(1);
          items[idx] = item;
        }

        return items.join(" ");
      } else {
        return value.charAt(0).toUpperCase() + value.substring(1);
      }
    }

    return "";  
  }

}
