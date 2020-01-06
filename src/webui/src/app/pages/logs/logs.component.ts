import {Component, Input, OnInit} from '@angular/core';
import {Weather} from "../../common/weather";
import {WeatherService} from "../../services/shared/weather.service";
import {LogsService} from "../../services/shared/logs.service";

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.scss']
})
export class LogsComponent implements OnInit {

  weathers: Weather [] = [];
  filterText: string;

  constructor(private logsService: LogsService) { }

  ngOnInit() {

    this.logsService.getAll().subscribe(res => {
      this.weathers = res;
    });
  }

}
