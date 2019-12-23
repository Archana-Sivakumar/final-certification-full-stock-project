import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  mail = "";
  constructor(private userService : UserService,
              private route : Router,
              private authService : AuthService) { }

  ngOnInit() {
  }

  send(){
    this.userService.getUserPassword(this.mail).subscribe((response) => {
      
      this.route.navigate(['login',true,"abc"]);
    });
    
  }

  back(){
    this.route.navigate(['']);
  }
  
  logout(){
    this.authService.logout();
  }

}
