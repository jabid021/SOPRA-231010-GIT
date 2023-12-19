import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  loginByPathVariable?: string;
  loginByQueryParam?: string;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.loginByPathVariable = params['login'];
    });

    this.route.queryParams.subscribe(params => {
      this.loginByQueryParam = params['login'];
    });
  }

}
