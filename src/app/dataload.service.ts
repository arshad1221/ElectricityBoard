import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { Observable, Subject, ReplaySubject, from, of, range } from 'rxjs';

import { map } from 'rxjs/operators';
import { __param } from 'tslib';
import { Connectionrequests } from './connectionrequests';



@Injectable()
export class DataloadService {
  constructor(private http: HttpClient) {}

  LoadData(): Observable<any> {
   console.log("api called")
     return this.http.get('http://localhost:8080/api/excel/userlist');
      
  }
  
  
 
  LoadData2(date1 :any,date2:any):Observable<any> {


   let queryParams = new HttpParams().append("date1",date1)
   .append("date2",date2);
   const url='http://localhost:8080/api/excel/date';
    return  this.http.get<Connectionrequests[]>(url,{params:queryParams});
    
 }

 LoadData3(): Observable<any> {
   console.log("api called")
     return this.http.get('http://localhost:8080/api/excel/userlistu');
      
  }
  updateuser(status :any,id:any):Observable<any> {
  
    
    console.log("hitting updateuser")

      let queryParams = new HttpParams().append("status",status)
      .append("id",id);
     
      const url='http://localhost:8080/api/excel/updtaestatus?id='+id+'&status='+status;
       return  this.http.put(url,{params:queryParams});
       
    }
   
  
  




  }

