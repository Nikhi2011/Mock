import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from './user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user: User[];
  signupForm: any;
  validate: any = true;
  error : any;
  
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.user = this.userService.getAllUser();
    this.signupForm = new FormGroup({
      'userName': new FormControl(),
      'firstName': new FormControl(),
      'lastName': new FormControl(),
      'password': new FormControl(),
      'confirmPassword': new FormControl()
    })
  }
  addingUser(signupUser) {
    if (signupUser.value.password == signupUser.value.confirmPassword) {
      this.userService.AddUser(signupUser.value).subscribe((response)=> {
        this.router.navigate(['login']);
      },
      (error) =>{
        this.error = error.error.message;
      });
      this.validate = true;
    } else {
      this.validate = false;
    }
  }
}
