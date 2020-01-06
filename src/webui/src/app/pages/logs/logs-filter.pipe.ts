import { Pipe, PipeTransform } from '@angular/core';
import {LogsComponent} from "./logs.component";

@Pipe({
  name: 'logsFilter'
})
export class LogsFilterPipe implements PipeTransform {

  transform(value: any, filterText?: any): any {
    if(!filterText)
      return value;
    return value.filter(
      item => item.city.toLowerCase().indexOf(filterText.toLowerCase()) > -1
    );
}}
