import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cart: any;
  total: any = 0;
  status: any;
  error: any;
  constructor(private cartService: CartService) { }

  ngOnInit() {
    this.cartService.getAllCart().subscribe((data) => {
      this.cart = data['menuItemList'];
      this.totaling();
    },
    (error) =>{
      this.error = error.error.message;
    });
   }
  totaling() {
      this.total = this.cartService.getAllCart().subscribe((data) => {
      this.total = data['total'];
    },
    (error) =>{
      this.error = error.error.message;
    });   
  }
  delete($event) {
    this.cartService.deleteCart($event).subscribe((data) => {
      this.cart = data;
      this.totaling();
    });
  }
}
