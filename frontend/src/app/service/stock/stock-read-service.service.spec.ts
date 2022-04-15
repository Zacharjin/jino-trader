import { TestBed } from '@angular/core/testing';

import { StockReadServiceService } from './stock-read-service.service';

describe('StockReadServiceService', () => {
  let service: StockReadServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StockReadServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
