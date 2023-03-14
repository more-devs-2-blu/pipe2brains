import { TestBed } from '@angular/core/testing';

import { HttpCpfService } from './httpcpf.service';

describe('HttpcpfService', () => {
  let service: HttpCpfService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpCpfService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
