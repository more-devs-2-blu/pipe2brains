import { TestBed } from '@angular/core/testing';

import { HttpMeiService } from './httpmei.service';

describe('HttpmeiService', () => {
  let service: HttpMeiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpMeiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
