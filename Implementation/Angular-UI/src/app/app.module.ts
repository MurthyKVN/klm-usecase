import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { MatInputModule, MatAutocompleteModule, MatButtonModule, MatTableModule, MatPaginatorModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { AppComponent } from './app.component';
import { SearchComponent } from './search/search.component';
import { FaresComponent } from './fares/fares.component';
import { HeaderComponent } from './header/header.component';
import { LocationComponent } from './location/location.component';
import { HealthmonitorComponent } from './healthmonitor/healthmonitor.component';

import { LocationService } from './location.service';
import { FaresService } from './fares.service';
import { HealthmonitorService } from './healthmonitor.service';

const routes: Routes = [
  { path: '', component: SearchComponent },
  { path: 'home', component: SearchComponent },
  { path: 'locations', component: LocationComponent },
  { path: 'monitor/health', component: HealthmonitorComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    FaresComponent,
    HeaderComponent,
    LocationComponent,
    HealthmonitorComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatTableModule,
    MatPaginatorModule, 
    ChartsModule
  ],
  providers: [LocationService, FaresService, HealthmonitorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
