import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogsComponent } from './logs.component';
import {LogsRoutingModule} from "./logs.routing.module";
import {LogsService} from "../../services/shared/logs.service";
import { LogsFilterPipe } from './logs-filter.pipe';
import {FormsModule} from "@angular/forms";





@NgModule({
  declarations: [LogsComponent, LogsFilterPipe],
  imports: [
    CommonModule,
    LogsRoutingModule,
    FormsModule,

  ],
  providers: [LogsService]
})
export class LogsModule { }
