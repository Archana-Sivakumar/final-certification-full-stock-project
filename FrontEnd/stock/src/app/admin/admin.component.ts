import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { AdminService } from '../admin.service';
import { AuthService } from '../auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  companyList: any;
  fileData: File = null;
  uploadResponse: any;
  fileStatus: boolean =false;
  userName:any;
  addCompanyStatus: any = false;
  addStockExchangeStatus: any =false;
  stockExchangeList:any;
  stockExchangeStatus: any =false;
  companyStatus: any =false;
  importStatus:any = true;
  constructor(private http: HttpClient, private adminService: AdminService, private authService: AuthService, private route:Router, private userService: UserService, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
     
      this.activatedRoute.paramMap
      .subscribe(params => {
        this.addStockExchangeStatus = params.get('exchangeStatus');
     
      
    this.userName = this.authService.getUser();
    })
  
  }

  uploadFile(event) {
      this.fileData = <File>event.target.files[0];
    
      let formData: FormData = new FormData();
      formData.append('file', this.fileData, this.fileData.name);
    
      this.adminService.uploadFile(formData).subscribe(
              (response)=>{
        
               } ,
               (responseError)=>{
                 this.route.navigate(['summary']);
               })
    }

    stockExchange(){
      this.stockExchangeStatus = true;
      this.addStockExchangeStatus =false;
      this.importStatus = false;
      this.companyStatus = false;
         this.adminService.getAllStockExchange().subscribe((response)=>{
           this.stockExchangeList = response;
         })
    }

    company() {
      this.companyStatus = true;
      this.importStatus = false;
      this.addStockExchangeStatus =false;
      this.stockExchangeStatus=false;
      this.userService.getAllCompanies().subscribe((response)=>
      {
        this.companyList = response;
      })
    }


    addStockExchange() {
      this.route.navigate(['addStockExchange']);
    }

    logout() {
      this.authService.logout();
    }

    import() {
      this.importStatus = true;
      this.companyStatus = false;
      this.addStockExchangeStatus =false;
      this.stockExchangeStatus=false;
    }
  }

