import {Component, Input, OnInit} from '@angular/core';
import {WeatherService} from "../../services/shared/weather.service";
import {Weather} from "../../common/weather";

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.scss']
})
export class WeatherComponent implements OnInit {

  weathers: Weather;
  cityName: string;

  isShow = false;

  constructor(private weatherService: WeatherService) { }

  ngOnInit() {

  }

  getWeather(city){
    this.weatherService.getByCity(city).subscribe(res => {
      this.weathers = res;
      console.log(res);
    });
  }

  toggleDisplay() {
    this.isShow = !this.isShow;
  }


}
