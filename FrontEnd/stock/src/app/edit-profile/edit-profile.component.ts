import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  editProfileForm: FormGroup;
  userName : any;
  contactNumber : any;
  profile : any;

  constructor(private route: Router,
              private authService : AuthService,
              private userService : UserService) {


                this.editProfileForm = new FormGroup({
                  "id" : new FormControl(''),
                  "userName" : new FormControl(''),
                  "email" :  new FormControl(''),
                  "mobileNumber" :  new FormControl(''),
                  "confirmStatus" : new FormControl('')
              
                })
    
   }

  ngOnInit() {

    this.userName = this.authService.getUser();
        this.userService.getOneUser(this.userName).subscribe((response) => {
          this.profile = response;
          if(this.profile!=null){

            this.editProfileForm = new FormGroup({
            
              "id" : new FormControl(this.profile.id),
              "userName" : new FormControl(this.profile.userName),
              "email" :  new FormControl(this.profile.email),
              "mobileNumber" :  new FormControl(this.profile.mobileNumber),
              "confirmStatus" : new FormControl(this.profile.confirmStatus)
          
            })
          }
    });
  }

  cancel(){
    this.route.navigate(['user']);
  }

  edit(editProfileForm){
    this.userService.editUserProfile(editProfileForm.value).subscribe((response) => {
      let status = response;
      this.route.navigate(['user',status]);
    });
   
  }

  back(){
    this.route.navigate(['user']);
  }

  logout(){
    this.authService.logout();
  }

}


