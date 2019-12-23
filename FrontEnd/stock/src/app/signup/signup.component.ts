import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

userForm:FormGroup;
userName: string;
mobileNumber: number;
email: string;
password: string;
signUpStatus: boolean=false;
status: boolean = false;

  constructor(private userService: UserService, private route: Router) { }

  ngOnInit() {

     this.userForm= new FormGroup({
       "userName": new FormControl(this.userName,[Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      "mobileNumber":  new FormControl(this.mobileNumber, [Validators.required,  Validators.max(9999999999),Validators.min(1000000000)]),
      "email": new FormControl(this.email, [Validators.required, Validators.maxLength(50)]),
      "password": new FormControl(this.password, [Validators.required, Validators.minLength(5)]),
  
    });

  }
     send(userForm) {  

        let user = {
          "userName" : userForm.value.userName,
          "password" : userForm.value.password,
          "email" : userForm.value.email,
          "mobileNumber" : userForm.value.mobileNumber,
          "confirmStatus" : false
        }

        this.userService.addUser(user).subscribe((response) => {
          
            this.route.navigate(['login',1]);
        }, 
          (responseError) => {
            if(responseError.error.message === 'User already exists'){
            this.route.navigate(['login',2]);
            }
        });
     
    }

    back() {
      this.route.navigate(['']);
    }

    login() {
      this.route.navigate(['login']);
    }

}
