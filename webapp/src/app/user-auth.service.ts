import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {
  loggedIn: boolean = false;
  userName: any;
  userType: any = "anonymous";
  userStatus: any;
  constructor(private httpClient : HttpClient) { }
  
  private authenticationApiUrl = environment.baseUrl + '/authentication-service/truyum/authenticate';
  private token: string;
  private role: string;
  private user: string;

  authenticate(user: string, password: string): Observable<any>{
    let credentials = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials);
    return this.httpClient.get(this.authenticationApiUrl, {headers})
  }

    public setToken(token: string) {
      this.token = token;
    }
    public getToken() {
      return this.token;
    }

    public setRole(role: string) {
      this.role = role;
    }
    public getRole() {
      return this.role;
    }

    public setUser(user: string) {
      this.user = user;
    }
    public getUser() {
      return this.user;
    }
  
  guarding(nameType, userName) {
    if (nameType == "admin") {
      this.userType = "admin";
    } else
      if (nameType == "customer") {
        this.userType = "customer";
      } else {
        this.userType = "anonymous";
      }
    this.userName = userName;
  }
  getUserName() {
    return this.userName;
  }
  getUserType() {
    return this.userType;
  }
  login() {
    this.loggedIn = true;
  }
  logout() {
    this.userType = "anonymous"
    this.setToken('');
    this.setRole(this.userType);
    this.loggedIn = false;
  }
  isLoggedIn() {
    return this.loggedIn;
  }
}
