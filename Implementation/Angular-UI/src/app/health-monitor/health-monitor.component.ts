import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions } from 'chart.js';

import { HealthMonitorService } from '../shared/health-monitor.service';

@Component({
  selector: 'app-health-monitor',
  templateUrl: './health-monitor.component.html'
})
export class HealthMonitorComponent implements OnInit {
  labels:Array<any> = ["2XX", "4XX", "5XX"]
  stats:any = {};

  constructor(private healthMonitorService:HealthMonitorService) { }

  ngOnInit() {
    this.healthMonitorService.getGetHealthData().subscribe(result => {
      let resChartData: Array<any> = [];
      resChartData.push(result.statusOKCount);
      resChartData.push(result.status4XXCount);
      resChartData.push(result.status5XXCount);

      this.stats = {
        chartData: resChartData,
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
