import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { BackgroundBlackDirective } from './background-black.directive';
import { TodoStatePipe } from './todo-state.pipe';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscTextFieldComponent } from './asc-text-field/asc-text-field.component';

@NgModule({
  declarations: [
    AppComponent,
    BackgroundBlackDirective,
    TodoStatePipe,
    HelloWorldComponent,
    AscBoldComponent,
    AscTextFieldComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
