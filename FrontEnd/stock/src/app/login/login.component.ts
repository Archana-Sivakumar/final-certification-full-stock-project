import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 loginForm: FormGroup;
 username: string;
 password: string;
 validationStatus: boolean = false;
 show: boolean = false;
 status: any;
 forgotPassword: any;
 authenticationStatus : any;

 constructor(  private activateRoute: ActivatedRoute,
                private authService: AuthService,
                 private route: Router
                 ) { }

  ngOnInit() {
    this.activateRoute.paramMap.subscribe(params => {
      this.status = params.get('status');
      this.forgotPassword = params.get('pass');
  
      this.loginForm= new FormGroup({
          "username": new FormControl(this.username, Validators.required),
          "password": new FormControl(this.password, Validators.required)
      });
    });

  }

  send(loginForm) {

    this.authService.authenticate(loginForm.value.username, loginForm.value.password)
       .subscribe((response) => {

              this.validationStatus = false;

              this.authService.setToken(response.token);
              this.authService.setRole(response.role);
              this.authService.setUser(response.user);
              this.authService.login();
              if(response.role=="ADMIN"){
                this.route.navigate(['admin']);
              }

              if(response.role=="USER"){
              this.route.navigate(['user']);
              }

      },
      (responseError) => {
    
          if(responseError.error.message === 'REJECTED') {
            this.authenticationStatus = "REJECTED";

          } else{
            this.validationStatus = true;
          
          }
    });
  }
    
  passwordFunction() {
    this.show = !this.show;
  }

  back(){
    this.route.navigate(['']);
  }

  signIn(){
      this.route.navigate(['signup']);
  }
   
}
