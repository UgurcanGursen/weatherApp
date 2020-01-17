import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WeatherComponent } from './weather.component';
import {WeatherRoutingModule} from "./weather.routing.module";
import {WeatherService} from "../../services/shared/weather.service";
import {FormsModule} from "@angular/forms";
import {HeaderComponent} from "../../_layout";



@NgModule({
  declarations: [WeatherComponent],
  imports: [
    CommonModule,
    WeatherRoutingModule,
    FormsModule
  ],
  providers: [WeatherService]
})
export class WeatherModule { }
