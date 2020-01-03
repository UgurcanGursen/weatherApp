import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Weather} from "../../common/weather";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  private WEATHER_PATH = '/weather';

  constructor(private apiService: ApiService) {
  }


  getByCity(city): Observable<any> {
    return this.apiService.get(this.WEATHER_PATH + '/' + city).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }


}
