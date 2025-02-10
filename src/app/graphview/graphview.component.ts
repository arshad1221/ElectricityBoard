import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Chart ,registerables} from 'node_modules/chart.js/auto';
import { DataloadService } from '../dataload.service';
Chart.register();


@Component({
  selector: 'app-graphview',
  templateUrl: './graphview.component.html',
  styleUrls: ['./graphview.component.css']
})




 
export class GraphviewComponent  implements OnInit  {
 
public test ="arshad";
public isdisables=false;

public haserror=true;
  routes: any;

  constructor(private load: DataloadService){}
  chardata: any[]=[];
  
  month:  any[]=[];


  creategraphview(graphview :string): void{
    this.routes.navigate(['/graphview']);
 
   }

ngOnInit(): void {
  
  
   
    


  
   this.load.LoadData3().subscribe(Connectionrequests=>{
   
     
    
     this.month.push(Connectionrequests.January);
     this.month.push(Connectionrequests.February);
     this.month.push(Connectionrequests.March);
     this.month.push(Connectionrequests.April);
     this.month.push(Connectionrequests.May);
     this.month.push(Connectionrequests.June);
     this.month.push(Connectionrequests.July);
     this.month.push(Connectionrequests.August);
     this.month.push(Connectionrequests.September);
     this.month.push(Connectionrequests.October);
     this.month.push(Connectionrequests.November);
     this.month.push(Connectionrequests.December);
     
     console.log(this.month[0]);

     this.renderchart(this.month);
   })}


    test1(){
      let a= window.location.href
      return "hello" +a
    }

    public special=true

   public message ={

    p :!this.haserror,
    g :this.special,
    h :this.haserror



   }


   renderchart(month: any[] ){
  
  const chart = new Chart("barchart", {
    type: 'bar', //this denotes tha type of chart
   
    data: {// values on X-Axis
      
      labels: ["January","February","March", "April","May","June","July", "August","September", "October","November","December"
                ], 
       datasets: [
        {
          
          label: "CONNECTION REQUESTS",
          data: month,
          backgroundColor: ["#ed1e1e", "#2269e5", "#fce302", "#04f759", "#fc9700","#ed1e1e", "#2269e5", "#fce302",]
        },
         
      ]
    },
    options: {
      aspectRatio:2.5
    }
    
  });
 
}


}