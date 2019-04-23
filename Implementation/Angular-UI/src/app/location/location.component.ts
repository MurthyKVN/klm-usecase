import { Component, OnInit, ViewChild } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { DataSource } from '@angular/cdk/collections';
import { MatPaginator } from '@angular/material';

import { LocationService } from '../shared/location.service';
import { Location } from '../model/location';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html'
})
export class LocationComponent implements OnInit {
  totalCount = 0;
  displayedColumns: string[] = ['name', 'description', 'code'];
  dataSource = new LocationDataSource(this.locationService);
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private locationService:LocationService) { }

  ngOnInit() {
    this.dataSource.totalCountSubject.subscribe(count => {this.totalCount = count});
    this.dataSource.load(1,5); // inital load pageNo=0 size=5
  }

  ngAfterViewInit() {
    this.paginator.page
        .pipe(
            tap(() => this.loadLocations())
        )
        .subscribe();
  }

  loadLocations(){
    this.dataSource.load(this.paginator.pageIndex+1, this.paginator.pageSize);
  }

}

class LocationDataSource extends DataSource<Location> {
  private locationSubject = new BehaviorSubject<Location[]>([]);
  
  public totalCountSubject = new BehaviorSubject<number>(0);

  constructor(private locationService: LocationService) {
    super();
  }
  connect(): Observable<Location[]> {
    return this.locationSubject.asObservable(); 
  }
  disconnect() {}

  public load(page:number, size:number){
    this.locationService.getLocations(page, size).pipe(
          catchError(error => Observable.of([])))
        .subscribe(result => {
          this.locationSubject.next(result['_embedded'].locations);
          this.totalCountSubject.next(result['page'].totalElements);
        });
  }
}
