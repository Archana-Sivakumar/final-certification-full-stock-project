import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  userName : any;
  loginForm : FormGroup;
  profile : any;

  constructor(private route: Router,
    private authService : AuthService,
    private userService : UserService) {
      
      this.loginForm = new FormGroup({
        "currentPassword" : new FormControl(''),
        "password" : new FormControl(''),
        "confirmPassword" : new FormControl('')
       
      })

     }

  ngOnInit() {
    this.userName = this.authService.getUser();
    this.userService.getOneUser(this.userName).subscribe((response) => {
      this.profile = response;
    });
  }

  back() {
    this.route.navigate(['user']);
  }

  logout() {
    this.authService.logout();
  }

  send(passwordForm){
    
    this.profile.password = passwordForm.value.confirmPassword;
    this.profile.rawPassword = passwordForm.value.confirmPassword;

    this.userService.updateUserPassword(this.profile).subscribe((response) => {
      let status = response;
      this.route.navigate(['user',status]);
    });
  }
}
