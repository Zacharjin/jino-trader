import { Component, OnInit } from '@angular/core';
import { StockValue } from './model/stock'

const ELEMENT_DATA: StockValue[] = [
  { icon: 'https://s3-symbol-logo.tradingview.com/apple.svg', position: 1, name: 'APPL', last: 170.09, change: -2.05, changePercent: -1.19 },
  { icon: 'https://s3-symbol-logo.tradingview.com/tesla.svg', position: 2, name: 'TSLA', last: 1025.49, change: -31.77, changePercent: -3.00 },
  { icon: 'https://s3-symbol-logo.tradingview.com/netflix.svg', position: 3, name: 'NFLX', last: 355.88, change: -6.27, changePercent: -1.73 },
];

@Component({
  selector: 'app-stock-table',
  templateUrl: './stock-table.component.html',
  styleUrls: ['./stock-table.component.scss']
})
export class StockTableComponent implements OnInit {
  displayedColumns: string[] = ['name', 'last', 'change', 'changePercent'];

  public dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit(): void {
  }

  public getTextStyle(value: number) {
    return value > 0 ? 'good' : 'bad';
  }
}
