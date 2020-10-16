import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../user-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private userAuthService: UserAuthService, private router: Router) { }

  ngOnInit() {
  }
  loggingout() {
    this.userAuthService.logout();
    this.router.navigate(['']);
    return this.userAuthService.getUserType();
  }
  userStatus() {
    return this.userAuthService.getUserType();
  }
  userName() {
    return this.userAuthService.getUserName();
  }
} 
