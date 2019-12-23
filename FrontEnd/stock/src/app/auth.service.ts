import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  role: string="anonymous";
  user: any;
  logged: boolean = false;
  loginStatus: boolean = false;
  id: any;
  initialRole: string;
  private authenticationApiUrl = environment.authenticationbaseUrl+"/authenticate";
  private token: string;
  
  constructor(private httpClient: HttpClient,
              private route: Router,) {

  }
  authenticate(user: string, password: string): Observable<any> {
    let credentials = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials);
    return this.httpClient.get(this.authenticationApiUrl, {headers});
  }

  public setToken(token: string) {
    this.token = token;
  }

  public getToken() {
    return this.token;
  }

  public setInitialRole(initialRole: string) {
    this.initialRole = initialRole;
  }

  public getInitialRole() {
    return this.initialRole;
  }

  getRole() {
    return this.role;
  }

  setRole(role: any) {
   this.role = role;
  }

  login() {
    this.logged = true;
  }


  isLoggedIn() {
    return this.logged;
  }


  public setUser(user: any) {
    this.user = user;
  }

  public getUser() {
    return this.user;
  }
   

  logout() {
    this.setToken("");
    this.loginStatus=false;
    this.route.navigate(['']);

   }
 
}
