import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { StockCell } from './model/stock-cell'
import { StockValue } from './model/stock-value'



@Component({
  selector: 'app-stock-table',
  templateUrl: './stock-table.component.html',
  styleUrls: ['./stock-table.component.scss']
})
export class StockTableComponent implements OnInit, OnChanges {
  displayedColumns: string[] = ['name', 'last', 'change', 'changePercent'];

  @Input()
  public data: StockValue[] = [];

  public dataSource: StockCell[] = [];

  constructor() { }
  ngOnChanges(changes: SimpleChanges): void {
    this.dataSource = this.data.map(d => {
      const changeValue = d.current.value - d.last.value;
      const changePercentValue = changeValue / d.last.value;

      return {
        icon: d.icon,
        position: d.position,
        name: d.name,
        last: d.current.value,
        change: changeValue,
        changePercent: changePercentValue
      }
    });

  }

  ngOnInit(): void {
  }

  public getTextStyle(value: number) {
    return value > 0 ? 'positive' : 'negative';
  }
}
