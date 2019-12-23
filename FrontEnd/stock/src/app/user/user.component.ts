import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  userName : any
  editedStatus : any
  companyList: any;
  filteredCompanyList: any;
  constructor(private userService:UserService, private route:Router, private authService:AuthService, private activateRoute: ActivatedRoute) { }

  ngOnInit() {

    this.activateRoute.paramMap
        .subscribe(params=> {
          this.editedStatus=params.get('editedStatus');

    this.userName = this.authService.getUser();
  
      this.userService.getAllCompanies().subscribe((response)=>
      {
       
        this.companyList = response;
        this.filteredCompanyList = this.companyList;
       
      })
    });
  }
  
  search(searchString) {

    this.filteredCompanyList = this.userService.getFilterCompany(searchString,this.companyList);
  }

  viewStockPrice(companyCode){

    this.route.navigate(['view-stock-price', companyCode]);
  }

  back(){
    this.route.navigate(['']);
  }

  logout(){
    this.authService.logout();
  }

  editProfile(){
    this.route.navigate(['editProfile']);
  }

  changePassword(){
    this.route.navigate(['changePassword']);
  }
  
}
