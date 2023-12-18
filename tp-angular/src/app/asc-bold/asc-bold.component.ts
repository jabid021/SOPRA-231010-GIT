import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'asc-bold',
  templateUrl: './asc-bold.component.html',
  styleUrls: ['./asc-bold.component.css']
})
export class AscBoldComponent {
  cpt: number = 0;

  alerteSurLeGras() {
    alert("j'ai cliqué sur le texte en gras");
  }

  @HostListener("click", ["$event"])
  alerteSurToutLeComposant(event: any) {
    console.log(++this.cpt);
    alert("j'ai cliqué sur mon composant");
  }
}
