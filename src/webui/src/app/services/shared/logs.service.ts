import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class LogsService {

  private WEATHER_PATH = '/weather';

  constructor(private apiService: ApiService) {
  }

  getAllPageable(page): Observable<any> {
    return this.apiService.get(this.WEATHER_PATH + '/pagination', page).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }

  getAll(): Observable<any> {
    return this.apiService.get(this.WEATHER_PATH).pipe(map(
      res => res.sort((a, b) => new Date(b.createdAt).getTime() - new Date(a.createdAt).getTime() )
    ));
  }

  getById(id): Observable<any> {
    return this.apiService.get(this.WEATHER_PATH+"/a/"+id).pipe(map(
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


  delete(id): Observable<any> {
    return this.apiService.delete(this.WEATHER_PATH + '/w/' + id).pipe(map(
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
