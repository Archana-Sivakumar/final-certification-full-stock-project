import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdminComponent } from './admin/admin.component';
import { SummaryComponent } from './summary/summary.component';
import { UserComponent } from './user/user.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { SearchComponent } from './search/search.component';
import { ViewStockPriceComponent } from './view-stock-price/view-stock-price.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomeComponent } from './home/home.component';
import { AddStockExchangeComponent } from './add-stock-exchange/add-stock-exchange.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdminComponent,
    SummaryComponent,
    UserComponent,
    EditProfileComponent,
    SearchComponent,
    ViewStockPriceComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent,
    HomeComponent,
    AddStockExchangeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
