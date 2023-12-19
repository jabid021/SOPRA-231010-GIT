import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { ListComponent } from './list/list.component';
import { TodoComponent } from './todo/todo.component';

const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "list", component: ListComponent},
  {path: "todo", component: TodoComponent},
  {path: "user", component: UserComponent},
  {path: "user/:login", component: UserComponent},
  {path: "", pathMatch: "full", redirectTo: "home"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
