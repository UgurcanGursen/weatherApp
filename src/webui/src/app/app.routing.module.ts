import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppLayoutComponent} from "./_layout";




const routes: Routes = [
  {
    path: '',component: AppLayoutComponent,
    children: [
      {path: '', pathMatch: 'full', redirectTo: 'weather'},
      {path: 'weather', loadChildren: './pages/weather/weather.module#WeatherModule'},
      {path: 'logs', loadChildren: './pages/logs/logs.module#LogsModule'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
