import { Component, OnInit, Input } from '@angular/core';

import { Fare } from '../model/fare';

@Component({
  selector: 'app-fares',
  templateUrl: './fares.component.html',
  styleUrls: ['./fares.component.css']
})
export class FaresComponent implements OnInit {

  @Input() fareData:Fare;

  constructor() { }

  ngOnInit() {
  }

}
