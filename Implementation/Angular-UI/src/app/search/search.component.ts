import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { catchError, debounceTime, distinctUntilChanged, map, tap, switchMap } from 'rxjs/operators';

import {FormControl} from '@angular/forms';

import { LocationService } from '../shared/location.service';
import { FaresService } from '../shared/fares.service';

import { Fare } from '../model/fare';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  loader = false;
  origin = new FormControl();
  destination = new FormControl();
  originLocations = {};
  destinationLocations = {};
  fare:Fare;
  subscription:Subscription;
  initData = {
    _embedded: {
      locations: []
    }
  }

  constructor(private locationService:LocationService, private faresService:FaresService) { }

  ngOnInit() {
    this.originLocations = this.origin
    .valueChanges
    .pipe(
      debounceTime(300),
      switchMap(value => this.locationService.getLocationSuggessions(value).
        pipe(catchError((error)=> { console.log(error); return Observable.of(this.initData); }))
      )
    );

    this.destinationLocations = this.destination
     .valueChanges
     .pipe(
       debounceTime(300),
       switchMap(value => this.locationService.getLocationSuggessions(value).
          pipe(catchError((error)=> { console.log(error); return Observable.of(this.initData); }))
       )
      );
  }

  displayLocation(location){
    if(location){
      return location.name;
    }
  }

  selected(event){
    event.option.deselect();
  }

  search(){
    if(this.subscription){
      this.subscription.unsubscribe();
    }
    if(this.origin.value==null || this.origin.value.code==null){
      alert('Select Origin location!!!');
      return;
    }
    if(this.destination.value==null || this.destination.value.code==null){
      alert('Select Destination location!!!');
      return;
    }

    this.loader = true;
    this.subscription = this.faresService.getFares(this.origin.value.code, this.destination.value.code)
      .subscribe(data =>
      { 
        this.loader = false;
        //temporary solution for location details
        data.originLocation = this.origin.value;
        data.destLocation = this.destination.value;

        this.fare = data;
        console.log(this.fare);
      }, error => {
        this.loader = false;
         console.log('error fetching fare details');
      });
  }

}
