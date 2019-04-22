import { TestBed, inject } from '@angular/core/testing';

import { HealthmonitorService } from './healthmonitor.service';

describe('HealthmonitorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HealthmonitorService]
    });
  });

  it('should be created', inject([HealthmonitorService], (service: HealthmonitorService) => {
    expect(service).toBeTruthy();
  }));
});
