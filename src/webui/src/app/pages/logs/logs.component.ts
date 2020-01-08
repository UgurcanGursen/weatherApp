import {Component, Input, OnInit} from '@angular/core';
import {Weather} from "../../common/weather";
import {WeatherService} from "../../services/shared/weather.service";
import {LogsService} from "../../services/shared/logs.service";
import {User} from "../../common/user";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../security/authentication.service";

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.scss']
})
export class LogsComponent implements OnInit {

  weathers: Weather [] = [];
  filterText: string;
  currentUser: User;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private logsService: LogsService) {
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }

  ngOnInit() {

    this.logsService.getAll().subscribe(res => {
      this.weathers = res;
    });
  }

  deleteLog(value) {
    return this.logsService.delete(value).subscribe(response => {
      this.logsService.getAll().subscribe(res => {
        this.weathers = res;
      });
    });
  }

  get isAdmin() {
    return this.currentUser && this.currentUser.username === 'root' ;
  }

}
