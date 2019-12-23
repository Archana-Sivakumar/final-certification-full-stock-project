import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {


  summary: any;
  constructor(private adminService: AdminService, private authService:AuthService,private route: Router) { }

  ngOnInit() {

    this.adminService.getSummary().subscribe((response)=>{
      this.summary=response;
    });
  }

  back(){
    this.route.navigate(['admin']);
  }

  logout(){
    this.authService.logout();
  }
  
}
