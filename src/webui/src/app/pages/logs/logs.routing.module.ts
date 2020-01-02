import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogsComponent } from './logs.component';
import {RouterModule, Routes} from "@angular/router";



const routes: Routes = [
  {
    path: '',
    component: LogsComponent
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class LogsRoutingModule { }
