import { Component, OnInit } from '@angular/core';
import { StockValue } from '../stock-table/model/stock-value';

const ELEMENT_DATA: StockValue[] = [
  { icon: 'https://s3-symbol-logo.tradingview.com/apple.svg', position: 1, name: 'APPL', current: { value: 170.09 }, last: { value: 171.19 } },
  { icon: 'https://s3-symbol-logo.tradingview.com/tesla.svg', position: 2, name: 'TSLA', current: { value: 1025.49 }, last: { value: 170.09 } },
  { icon: 'https://s3-symbol-logo.tradingview.com/netflix.svg', position: 3, name: 'NFLX', current: { value: 355.88 }, last: { value: 170.09 } }
];

@Component({
  selector: 'app-stock-side-panel',
  templateUrl: './stock-side-panel.component.html',
  styleUrls: ['./stock-side-panel.component.scss']
})
export class StockSidePanelComponent implements OnInit {

  data = ELEMENT_DATA;

  constructor() { }

  ngOnInit(): void {
  }

}
