import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { catchError } from 'rxjs/operators';

import { Fare } from './model/fare';

@Injectable()
export class FaresService {

  private fareUrl:string = "/travel/fares";
  
  constructor(private http:HttpClient) { }

  getFares(originCode:string, destinationCode:string){
    let url = this.fareUrl;
    return this.http.get<Fare>(url, {params:{origin: originCode, dest: destinationCode}});
  }

}
