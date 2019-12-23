import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdminComponent } from './admin/admin.component';
import { SummaryComponent } from './summary/summary.component';
import { UserComponent } from './user/user.component';
import { ViewStockPriceComponent } from './view-stock-price/view-stock-price.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomeComponent } from './home/home.component';
import { AddStockExchangeComponent } from './add-stock-exchange/add-stock-exchange.component';
import { AuthGuardGuard } from './auth-guard.guard';


const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'login/:status', component: LoginComponent},
  {path:'admin/:exchangeStatus', component: AdminComponent,canActivate:[AuthGuardGuard]},
  {path:'login/:pass/:err', component: LoginComponent},
  {path:'user/:editedStatus', component: UserComponent,canActivate:[AuthGuardGuard]},
  {path:'signup', component: SignupComponent},
  {path:'admin', component: AdminComponent,canActivate:[AuthGuardGuard]},
  {path:'summary', component: SummaryComponent,canActivate:[AuthGuardGuard]},
  {path:'user', component: UserComponent,canActivate:[AuthGuardGuard]},
  {path:'view-stock-price/:code', component: ViewStockPriceComponent,canActivate:[AuthGuardGuard]},
  {path:'changePassword', component: ChangePasswordComponent,canActivate:[AuthGuardGuard]},
  {path:'editProfile', component: EditProfileComponent,canActivate:[AuthGuardGuard]},
  {path:'forgotPassword', component: ForgotPasswordComponent,canActivate:[AuthGuardGuard]},
  {path:'addStockExchange', component: AddStockExchangeComponent,canActivate:[AuthGuardGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
