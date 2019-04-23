import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { catchError } from 'rxjs/operators';

import { Metrics } from '../model/metrics';

@Injectable()
export class HealthMonitorService {

  private actuatorUrl:string = "/travel/actuator";
  
  constructor(private http:HttpClient) { }

  getGetHealthData(){
    let url = this.actuatorUrl + "/getHealthMetrics";
    return this.http.get<Metrics>(url);
  }

}
