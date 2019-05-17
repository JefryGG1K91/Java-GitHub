import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  public login(username: string, passwordinput: string): void {
      console.log('Hello ' + username + ' welcome to $&^&*^8767');
   }

}
