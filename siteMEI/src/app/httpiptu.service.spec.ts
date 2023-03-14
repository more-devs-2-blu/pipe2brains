import { TestBed } from '@angular/core/testing';

import { HttpIptuService } from './httpiptu.service';

describe('HttpiptuService', () => {
  let service: HttpIptuService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpIptuService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
