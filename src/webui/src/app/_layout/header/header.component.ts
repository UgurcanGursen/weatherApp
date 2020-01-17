import { Component, OnInit } from '@angular/core';
import {User} from "../../common/user";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../security/authentication.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  currentUser: User;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
  }

  get isAdmin() {
    return this.currentUser && this.currentUser.role === 'ADMIN' ;
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

}


