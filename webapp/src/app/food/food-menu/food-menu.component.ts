import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { Router, ActivatedRoute, GuardsCheckEnd } from '@angular/router';
import { CartService } from 'src/app/shopping/cart.service';
import { User } from 'src/app/site/signup/user';
import { UserAuthService } from 'src/app/user-auth.service';

@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent implements OnInit {
  id: any;
  status: any;
  user: User[];
  userType: any;
  menuItem: any;
  filteredFood: any[];

  constructor(private foodService: FoodService, private router: Router, private cartService: CartService, private userAuthService: UserAuthService) { }

  ngOnInit() {
      this.foodService.getAllMenuItem().subscribe((data) => {
      this.menuItem = data;
      this.filteredFood = this.menuItem;
    });
  }
  edit($event) {
    this.id = $event.id;
    this.router.navigate(['item-edit', this.id]);
  }
  filterData(searchString) {
    this.filteredFood = this.foodService.getfilterData(searchString,this.menuItem);
  }
  add($event) {
    this.status = $event.id;
     this.cartService.AddCart($event).subscribe();
  }
}
