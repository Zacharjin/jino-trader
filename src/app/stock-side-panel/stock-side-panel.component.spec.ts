import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockSidePanelComponent } from './stock-side-panel.component';

describe('StockSidePanelComponent', () => {
  let component: StockSidePanelComponent;
  let fixture: ComponentFixture<StockSidePanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockSidePanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockSidePanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
