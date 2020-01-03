import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogsComponent } from './logs.component';
import {LogsRoutingModule} from "./logs.routing.module";
import {LogsService} from "../../services/shared/logs.service";




@NgModule({
  declarations: [LogsComponent],
  imports: [
    CommonModule,
    LogsRoutingModule
  ],
  providers: [LogsService]
})
export class LogsModule { }
