import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app.routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './_layout/header/header.component';
import { FooterComponent } from './_layout/footer/footer.component';
import { NavbarComponent } from './_layout/navbar/navbar.component';
import { AppLayoutComponent } from './_layout/app-layout/app-layout.component';
import {ApiService} from "./services/api.service";
import {WeatherService} from "./services/shared/weather.service";
import {LogsService} from "./services/shared/logs.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    AppLayoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    ApiService,
    WeatherService,
    LogsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
