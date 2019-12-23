import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient: HttpClient, private authService:AuthService) { }

  uploadFile(formData){
    return this.httpClient.post(environment.uploadFileUrl+"/uploadFile",formData);
   }

   getSummary():Observable<any>{

    
    let token = 'Bearer '+this.authService.getToken();
    const httpOptions ={
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    
    return this.httpClient.get(environment.uploadFileUrl+"/summary", httpOptions);
    }

    getAllStockExchange():Observable<any>{

      
      let token = 'Bearer '+this.authService.getToken();
      const httpOptions ={
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': token
        })
      };
      
      return this.httpClient.get(environment.uploadFileUrl+"/stock-exchange", httpOptions);
  }

   addCompany(companyForm){
    let token = 'Bearer ' + this.authService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.post(environment.uploadFileUrl+"/add-company",companyForm,httpOptions);
  }

  addStockExchange(StockExchangeForm){
    let token = 'Bearer ' + this.authService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.post(environment.uploadFileUrl+"/add-stock-exchange",StockExchangeForm,httpOptions);
  }
}
