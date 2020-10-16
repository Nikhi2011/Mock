import { Injectable } from '@angular/core';
import { MenuItem } from './MenuItem';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserAuthService } from '../user-auth.service';
import { environment } from 'src/environments/environment';



@Injectable({
  providedIn: 'root'
})
export class FoodService {
  
  menuItem: MenuItem[];
  filteredFood: any[];
  categoryBox: any[];
  constructor(private httpClient : HttpClient, private userAuthService : UserAuthService) { 
    this.menuItem = [{
      id: 101,
      name: "Sandwich",
      price: 99,
      active : true,
      dateOfLaunch: new Date("03/15/2017"),
      category: "Main Course",
      freeDelivery: true,
      image: "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1053&q=80"
     },
     {
      id: 102,
      name: "Burger",
      price: 129,
      active : true,
      dateOfLaunch: new Date("12/23/2017"),
      category: "Main Course",
      freeDelivery: false,
      image: "https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
     },
     {
      id: 103,
      name: "Pizza",
      price: 149,
      active : true,
      dateOfLaunch: new Date("08/21/2017"),
      category: "Main Course",
      freeDelivery: false,
      image: "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1055&q=80"
     },
     {
      id: 104,
      name: "French Fries",
      price: 57,
      active : false,
      dateOfLaunch: new Date("07/02/2017"),
      category: "Starters",
      freeDelivery: true,
      image: "https://images.unsplash.com/photo-1526230427044-d092040d48dc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
     },
     {
      id: 105,
      name: "Chocolate Brownie",
      price: 32,
      active : true,
      dateOfLaunch: new Date("11/02/2022"),
      category: "Dessert",
      freeDelivery: true,
      image: "https://images.unsplash.com/photo-1564355808539-22fda35bed7e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1030&q=80"
     }]

     this.categoryBox = ["Main Course","Starters","Dessert"]
    
    }
    /* getAllMenuItem(){
      return this.menuItem;
    } */
    getAllMenuItem(){
      let token = 'Bearer '+this.userAuthService.getToken();
     const httpOptions = {
       headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': token
         
       })
       };
      return this.httpClient.get(environment.baseUrl +"/menu-items-service/truyum/menu-items",httpOptions);
    }
    getCategory(){
      return this.categoryBox;
    }
    getfilterData(searchString,menuItem){
      let filter = searchString.toLocaleLowerCase();
      this.filteredFood = menuItem.filter( (menu: MenuItem) => menu.name.toLocaleLowerCase().indexOf(filter)!=-1);
      return this.filteredFood;
    }
  /*   update(menu){
      let i:any;
      let arr: any[]= this.menuItem;
      for(i = 0; i < this.menuItem.length; i++){
        if(menu.id == arr[i].id){
          arr[i] = menu;
        }
      }
    } */

    update(menu){
      let token = 'Bearer '+this.userAuthService.getToken();
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': token
        })
        };
  
      return this.httpClient.put(environment.baseUrl + "/menu-items-service/truyum/menu-items",menu, httpOptions);
    }

    editMenuItem(id){
      let token = 'Bearer '+this.userAuthService.getToken();
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': token
        })
        };
  
      return this.httpClient.get(environment.baseUrl + "/menu-items-service/truyum/menu-items/"+id, httpOptions);
    }


}
