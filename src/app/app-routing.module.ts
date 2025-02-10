import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {GraphviewComponent} from '../app/graphview/graphview.component'
import { AppComponent } from './app.component';

const routes: Routes = [{path:'',component: AppComponent},{path:'graphview', component: GraphviewComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
