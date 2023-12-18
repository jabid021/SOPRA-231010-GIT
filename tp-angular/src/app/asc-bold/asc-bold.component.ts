import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'asc-bold',
  templateUrl: './asc-bold.component.html',
  styleUrls: ['./asc-bold.component.css']
})
export class AscBoldComponent implements OnInit {
  cpt: number = 0;

  @Input("param1")
  monParam1!: string;

  @Input()
  param2!: string;

  constructor() {
    console.log("monParam1:"+this.monParam1);
    console.log("param2:"+this.param2);
  }

  ngOnInit(): void {
    console.log("Oninit")
    console.log("monParam1:"+this.monParam1);
    console.log("param2:"+this.param2);
  }

  alerteSurLeGras() {
    alert("j'ai cliqué sur le texte en gras");
  }

  @HostListener("click", ["$event"])
  alerteSurToutLeComposant(event: any) {
    console.log(++this.cpt);
    alert("j'ai cliqué sur mon composant");
  }
}
