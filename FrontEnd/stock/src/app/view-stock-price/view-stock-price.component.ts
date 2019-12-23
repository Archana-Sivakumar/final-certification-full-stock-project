import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-view-stock-price',
  templateUrl: './view-stock-price.component.html',
  styleUrls: ['./view-stock-price.component.css']
})
export class ViewStockPriceComponent implements OnInit {

  companyCode: any;
  stockPrice: any;

  constructor(private activateRoute: ActivatedRoute, private userService: UserService,private route: Router, private authService:AuthService) { }
  

  ngOnInit() {
    this.activateRoute.paramMap
          .subscribe(params=> {
            this.companyCode=params.get('code');

        this.userService.getStockPrice(this.companyCode).subscribe((response)=>{
          this.stockPrice = response;
        })
    });
  }

  back(){
    this.route.navigate(['user']);
  }

  logout(){
    this.authService.logout();
  }
  
}
