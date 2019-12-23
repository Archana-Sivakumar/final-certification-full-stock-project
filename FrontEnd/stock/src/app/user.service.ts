import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient,private authService: AuthService) {
  }

  addUser(user){
   return this.httpClient.post(environment.signupbaseUrl+"/sign-up",user);
  }

    getAllCompanies():Observable<any>{

      
      let token = 'Bearer '+this.authService.getToken();
      const httpOptions ={
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': token
        })
      };
      
      return this.httpClient.get(environment.uploadFileUrl+"/company", httpOptions);
  }

  getFilterCompany(searchString,companyList) {
    let filterCompany = searchString.toLocaleLowerCase();
    return companyList.filter((company) => company.companyName.toLocaleLowerCase().indexOf(filterCompany)!= -1);
  }

  getStockPrice(companyCode):Observable<any>{

      
    let token = 'Bearer '+this.authService.getToken();
    const httpOptions ={
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    
    return this.httpClient.get(environment.uploadFileUrl+"/get-stock-price/"+companyCode, httpOptions);
}
getOneUser(userName){
  let token = 'Bearer '+this.authService.getToken();
    const httpOptions ={
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    
    return this.httpClient.get(environment.signupbaseUrl+"/user/"+userName, httpOptions);
}

editUserProfile(user){
  let token = 'Bearer '+this.authService.getToken();
    const httpOptions ={
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    
    return this.httpClient.put(environment.signupbaseUrl+"/edit-user",user, httpOptions);

}

updateUserPassword(user){
  let token = 'Bearer '+this.authService.getToken();
    const httpOptions ={
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    
    return this.httpClient.put(environment.signupbaseUrl+"/update-password",user, httpOptions);
}

getUserPassword(mailId){
  let token = 'Bearer '+this.authService.getToken();
  const httpOptions ={
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': token
    })
  };
  
  return this.httpClient.post(environment.signupbaseUrl+"/send-password/"+mailId, httpOptions);
}
}
