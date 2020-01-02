import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WeatherComponent } from './weather.component';
import {RouterModule, Routes} from "@angular/router";
import {LogsComponent} from "../logs/logs.component";


const routes: Routes = [
  {
    path: '',
    component: WeatherComponent
  },

];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class WeatherRoutingModule { }
