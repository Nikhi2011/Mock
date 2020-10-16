import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { UserAuthService } from 'src/app/user-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {

  @Input() menuItem: any;
  @Input() status: any;
  @Input() userType: any;
  @Output() editEmitter: any;
  @Output() addEmitter: any;
   date = new Date();
  loginStatus: any;
  constructor(private userAuthService: UserAuthService, private router: Router) {
    this.editEmitter = new EventEmitter();
    this.addEmitter = new EventEmitter();
  }

  ngOnInit() {
  }
  clickEdit() {
    this.editEmitter.emit(this.menuItem);
  }
  userStatus() {
    return this.userAuthService.getUserType();
  }
  clickAdd() {
    this.loginStatus = this.userAuthService.isLoggedIn();
    if (this.loginStatus == false) {

      this.router.navigate(['login',"false"]);
    } else {
      this.addEmitter.emit(this.menuItem);
    }
  }
}
