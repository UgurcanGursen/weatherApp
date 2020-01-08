import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppLayoutComponent} from "./_layout";
import {AuthGuard} from "./security/auth.guard";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";




const routes: Routes = [
  {
    path: '',component: AppLayoutComponent, canActivate: [AuthGuard],
    children: [
      {path: '', pathMatch: 'full', redirectTo: 'weather'},
      {path: 'weather', loadChildren: './pages/weather/weather.module#WeatherModule'},
      {path: 'logs', loadChildren: './pages/logs/logs.module#LogsModule'}
    ]
  },
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
