import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StockBenchmarkSummaryComponent } from './stock-benchmark-summary/stock-benchmark-summary.component';
import { NavbarComponent } from './navbar/navbar.component';
import { StockBoxChartComponent } from './stock-box-chart/stock-box-chart.component';
import { NgChartsModule } from 'ng2-charts';
import { StockSidePanelComponent } from './stock-side-panel/stock-side-panel.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StockTableComponent } from './stock-table/stock-table.component';
import { MatTableModule } from '@angular/material/table'  

@NgModule({
  declarations: [
    AppComponent,
    StockBenchmarkSummaryComponent,
    NavbarComponent,
    StockBoxChartComponent,
    StockSidePanelComponent,
    StockTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgChartsModule,
    BrowserAnimationsModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
