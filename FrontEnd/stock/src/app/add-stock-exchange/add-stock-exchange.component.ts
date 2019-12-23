import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-stock-exchange',
  templateUrl: './add-stock-exchange.component.html',
  styleUrls: ['./add-stock-exchange.component.css']
})
export class AddStockExchangeComponent implements OnInit {

  userName:any;
  stockExchange: FormGroup;
  stockExchangeName: any;
  brief: any;
  address:any;
  remarks: any;
  constructor(private route: Router,private authService : AuthService, private adminService:AdminService) { }

  ngOnInit() {
    this.userName = this.authService.getUser();
    this.stockExchange = new FormGroup({
      'stockExchangeName': new FormControl(this.stockExchangeName, [Validators.required]),
      'brief': new FormControl(this.brief, [Validators.required]),
      'address': new FormControl(this.address, [Validators.required]),
      'remarks': new FormControl(this.remarks, [Validators.required]),
    })
  }
  
  addStockExchangeForm(stockExchangeForm){
    
    let exchangeStatus : any;
    let stockForm: any={
      "stockExchangeName": stockExchangeForm.value.stockExchangeName,
      "brief": stockExchangeForm.value.brief,
      "address": stockExchangeForm.value.address,
      "remarks": stockExchangeForm.value.remarks,
    }
    this.adminService.addStockExchange(stockForm).subscribe((response) => {
      exchangeStatus = response;
      this.route.navigate(['admin',exchangeStatus]);
    });
  }

  back(){
    this.route.navigate(['admin']);
  }

  logout(){
    this.authService.logout();
  }

}
