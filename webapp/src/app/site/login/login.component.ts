import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../signup/user';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserAuthService } from 'src/app/user-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User[];
  loginForm: any;
  validation: any = true;
  status: any;
  error : any;
  constructor(private userService: UserService, private router: Router, private userAuthService: UserAuthService,private activatedRouter: ActivatedRoute) { }

  ngOnInit() {
    this.user = this.userService.getAllUser();
    this.loginForm = new FormGroup({
      'userName': new FormControl(),
      'password': new FormControl()
    })
    this.activatedRouter.paramMap.subscribe(params => {
       this.status = params.get('status')})
  }
  check(loginForm) {
/*     console.log(loginForm.value);
    for (let userDetail of this.user) {
      if ((userDetail.userName == loginForm.value.userName) && (userDetail.password == loginForm.value.password)) {
        this.userAuthService.guarding("customer", userDetail.userName);
        this.router.navigate(['food-menu']);
        this.validation = true;
      } else
        if (loginForm.value.userName == "admin" && loginForm.value.password == "pwd") {
          this.userAuthService.guarding("admin", "admin");
          this.router.navigate(['food-menu']);
          this.validation = true;
        }
        else {
          this.validation = false;
        }
    }
    this.userAuthService.login(); */

    this.userAuthService.authenticate(loginForm.value.userName, loginForm.value.password).subscribe((response)=> {
      this.userAuthService.setToken(response.token);
      this.userAuthService.setRole(response.role);
      this.userAuthService.setUser(response.user);
      if(response.role == "ADMIN"){
      this.userAuthService.guarding("admin", response.user);
      }
      if(response.role == "USER"){
        this.userAuthService.guarding("customer", response.user);
      }
      this.userAuthService.login();
      this.router.navigate(['food-menu']);
    },
    (error) =>{
      this.error = "invalid UserName/password";
    });
  }
}
