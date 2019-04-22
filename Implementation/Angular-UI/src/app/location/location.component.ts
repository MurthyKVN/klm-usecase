import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { DataSource } from '@angular/cdk/collections';

import { LocationService } from '../location.service';
import { Location } from '../model/location';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {
  displayedColumns: string[] = ['name', 'description', 'code'];
  dataSource = new LocationDataSource(this.locationService);
  
  constructor(private locationService:LocationService) { }

  ngOnInit() {
  }

}

class LocationDataSource extends DataSource<any> {
  constructor(private locationService: LocationService) {
    super();
  }
  connect(): Observable<Location[]> {
    return this.locationService.getLocations();
  }
  disconnect() {}
}
