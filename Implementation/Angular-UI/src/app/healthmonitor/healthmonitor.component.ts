import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions } from 'chart.js';

import { HealthmonitorService } from '../healthmonitor.service';

@Component({
  selector: 'app-healthmonitor',
  templateUrl: './healthmonitor.component.html',
  styleUrls: ['./healthmonitor.component.css']
})
export class HealthmonitorComponent implements OnInit {

  labels:Array<any> = ["2XX", "4XX", "5XX"]
  stats:any = {};

  constructor(private healthmonitorService:HealthmonitorService) { }

  ngOnInit() {
    this.healthmonitorService.getGetHealthData().subscribe(result => {
      let temp: Array<any> = [];
      temp.push(result.statusOKCount);
      temp.push(result.status4XXCount);
      temp.push(result.status5XXCount);

      this.stats = {
        chartData: temp,
        totalCount: result.totalCount,
        maxTime: result.maxTime,
        minTime: result.minTime        
      }

    },error => {
      console.log('error fetching health data.');
      console.log(error);
    });
  }

}
