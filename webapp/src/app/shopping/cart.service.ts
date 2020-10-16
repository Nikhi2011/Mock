import { Injectable } from '@angular/core';
import { Cart } from './cart/Cart';
import { UserAuthService } from '../user-auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cart: Cart[];
  totalPrice: any = 0;
  constructor(private httpClient : HttpClient, private userAuthService : UserAuthService) {
    this.cart = [{
      id: 101,
      name: "Sandwich",
      price: 99,
      category: "Main Course",
      free_delivery: true,
      image: "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1053&q=80"
    },
    {
      id: 102,
      name: "Burger",
      price: 129,
      category: "Main Course",
      free_delivery: false,
      image: "https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
    },
    {
      id: 103,
      name: "Pizza",
      price: 149,
      category: "Main Course",
      free_delivery: false,
      image: "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1055&q=80"
    },
    {
      id: 104,
      name: "French Fries",
      price: 57,
      category: "Starters",
      free_delivery: true,
      image: "https://images.unsplash.com/photo-1526230427044-d092040d48dc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
    },
    {
      id: 105,
      name: "Chocolate Brownie",
      price: 32,
      category: "Dessert",
      free_delivery: true,
      image: "https://images.unsplash.com/photo-1564355808539-22fda35bed7e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1030&q=80"
    }]
  }
 /*  getAllCart() {
    return this.cart;
  } */
  getAllCart() {
    let token = 'Bearer '+this.userAuthService.getToken();
     const httpOptions = {
       headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': token
       })
       };
      return this.httpClient.get(environment.baseUrl + "/menu-items-service/truyum/cart-items/"+this.userAuthService.getUserName(),httpOptions);
  }
  totalCart() {
    this.totalPrice = 0;
    for (let i = 0; i < this.cart.length; i++) {
      this.totalPrice = this.cart[i].price + this.totalPrice;
    }
    return this.totalPrice;
  }
/*   deleteCart(cartDetails: any) {
    let i: any;
    let arr: any[] = this.cart;
    for (i = 0; i < this.cart.length; i++) {
      if (cartDetails.id == arr[i].id) {
        arr.splice(i, 1);
        break;
      }
    }
    return 1;
  } */
/*   AddCart(cart) {
    let i: any;
    let temp: any = 0;
    let arr: any[] = this.cart;
    for (i = 0; i < this.cart.length; i++) {
      if (temp < arr[i].id) {
        temp = arr[i].id;
      }
      cart.id = temp++;
    }
    arr.push(cart);
    return cart.id;
  } */

  AddCart(cart){
    let token = 'Bearer '+this.userAuthService.getToken();
     const httpOptions = {
       headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': token
       })
       };
      return this.httpClient.post(environment.baseUrl + "/menu-items-service/truyum/cart-items/"+this.userAuthService.getUserName()+ "/" + cart.id, {},httpOptions);
  }

  deleteCart(cart) {
    let token = 'Bearer '+this.userAuthService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
      };
     return this.httpClient.delete(environment.baseUrl + "/menu-items-service/truyum/cart-items/"+this.userAuthService.getUserName()+ "/" + cart.id,httpOptions);
  }
}
