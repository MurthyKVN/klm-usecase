import { Component, OnInit, Input } from '@angular/core';

import { Fare } from '../model/fare';

@Component({
  selector: 'app-fares',
  templateUrl: './fares.component.html'
})
export class FaresComponent implements OnInit {

  @Input() fareData:Fare;

  constructor() { }

  ngOnInit() {
  }

}
