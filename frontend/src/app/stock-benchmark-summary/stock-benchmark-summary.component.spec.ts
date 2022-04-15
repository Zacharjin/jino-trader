import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockBenchmarkSummaryComponent } from './stock-benchmark-summary.component';

describe('StockBenchmarkSummaryComponent', () => {
  let component: StockBenchmarkSummaryComponent;
  let fixture: ComponentFixture<StockBenchmarkSummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockBenchmarkSummaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockBenchmarkSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
