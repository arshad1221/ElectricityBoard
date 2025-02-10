import { Component, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataloadService } from './dataload.service';
import { Observable, Subject, ReplaySubject, from, of, range } from 'rxjs';
import { Router } from '@angular/router';
import { GraphviewComponent } from './graphview/graphview.component';
import { ThisReceiver } from '@angular/compiler';
import { DataTablesModule } from 'angular-datatables/src/angular-datatables.module';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  dataFromServer : any;

  page:number=1;
  count:number=0;
  tableSize: number=5;
  tableSizes: any=[5,10,15,20];

 

  public  greetings="high interpolation";
  constructor(private load: DataloadService, private routes: Router) {}


  

  display = false;
  onPress() {
    //this.display = true;

    //To toggle the component
    this.display = !this.display;
  }

 

  applicantId: any;
  startdate: any;
  enddate: any;


  getDataServer() {
    let obj = this.load.LoadData();
    obj.subscribe((data) => {
      this.dataFromServer = data;
    });
  }
  

  ngOnInit() {
    this.getDataServer()
  }




  

  getapplicationdat() {

    console.log(this.enddate,this.startdate)
    let obj = this.load.LoadData2(this.startdate,this.enddate);
    obj.subscribe((data) => {
      this.dataFromServer = data;
    });
  }



  searchFilter() {
    /* this.searchList = this.searchText; */
    if (this.applicantId) {
      console.log(this.applicantId);
      this.dataFromServer = this.dataFromServer.filter((res: { id: any }) => {
        this.isdisables=false
        return res.id == this.applicantId;
      });
      console.log(this.dataFromServer);
    } else {
      this.getDataServer();
    }
  }
  
  public isdisables =true;
  status : any;
  show: boolean = false;
  
  updateUser(enable: boolean) {
const a=parseInt(this.applicantId);

this.show=enable;

    console.log(this.status,a+4)
    let obj= this.load.updateuser(this.status,a);
    obj.subscribe((data) => {
      this.dataFromServer = data;
     this.dataFromServer;
     this.getDataServer();
  
    });
    
     
  
  }
  


onTableDatachange(event:any){
   this.page=event;
   this.getDataServer();

   
}

onTableSizechange(event:any):void{
  this.tableSize=event.target.value;
  this.page=1;
    this.getDataServer();
  
  
}



}



