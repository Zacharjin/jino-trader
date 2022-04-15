import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockBoxChartComponent } from './stock-box-chart.component';

describe('StockBoxChartComponent', () => {
  let component: StockBoxChartComponent;
  let fixture: ComponentFixture<StockBoxChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockBoxChartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockBoxChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
