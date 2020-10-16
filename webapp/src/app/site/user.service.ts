import { Injectable } from '@angular/core';
import { User } from './signup/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  user: User[];
  constructor(private httpClient : HttpClient) { 
    this.user = [{
      userName : "",
      firstName : "",
      lastName : "",
      password : "",
      confirmPassword : ""
   }]
}
getAllUser(){
  return this.user;
}
/* AddUser(user){
  let arr: any[]= this.user;
  arr.push(user);
} */

AddUser(user){
   return this.httpClient.post(environment.baseUrl + "/authentication-service/truyum/users",user)
}
}
