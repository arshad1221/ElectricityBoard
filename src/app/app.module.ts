import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { DataloadService } from './dataload.service';

import { AppComponent } from './app.component';
import { GraphviewComponent } from './graphview/graphview.component';
import { AppRoutingModule } from './app-routing.module';

import { DataTablesModule} from 'angular-datatables';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  imports:      [ BrowserModule, FormsModule, HttpClientModule,AppRoutingModule,DataTablesModule,NgxPaginationModule],
  declarations: [ AppComponent, GraphviewComponent ],
  bootstrap:    [ AppComponent ],
  providers:    [DataloadService]
})
export class AppModule { }
