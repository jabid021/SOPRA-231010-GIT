import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'asc-text-field',
  templateUrl: './asc-text-field.component.html',
  styleUrls: ['./asc-text-field.component.css']
})
export class AscTextFieldComponent {
  @Input("label")
  leLabel!: string;
  @Input("value")
  laValue!: string;

  @Output()
  emetteur = new EventEmitter<string>();

  // changementInput(evt: any) {
  //   this.laValue = evt.target.value;
  //   this.emetteur.emit(evt.target.value);
  // }

  changementInput(value: string) {
    this.laValue = value;
    this.emetteur.emit(value);
  }
}
