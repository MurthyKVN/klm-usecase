import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';

import { LocationResponse } from '../model/location-response';

@Injectable()
export class LocationService {

  private locationUrl:string = "/travel/airports";

  constructor(private http:HttpClient) { }

  public getLocationSuggessions(term){

    let url = this.locationUrl;
   
    if(term.code){
      return this.http.get(url);
    }
    
    return this.http.get(url, { params:{ term: term }});
  }

  // For locations table
  public getLocations(page, size){
        let url = this.locationUrl;
        return this.http.get<LocationResponse>(url, {params: { page:page, size:size }});
  }
}
