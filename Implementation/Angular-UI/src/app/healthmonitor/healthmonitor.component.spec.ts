import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthmonitorComponent } from './healthmonitor.component';

describe('HealthmonitorComponent', () => {
  let component: HealthmonitorComponent;
  let fixture: ComponentFixture<HealthmonitorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HealthmonitorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthmonitorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
