import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/entities/patient';
import { PatientRegistration } from 'src/app/entities/patient-registration';
import { PatientService } from 'src/app/services/patient.service';
import * as XLXS from 'xlsx';
import {jsPDF} from 'jspdf';
import html2canvas from 'html2canvas';


@Component({
  selector: 'app-get-my-data',
  templateUrl: './get-my-data.component.html',
  styleUrls: ['./get-my-data.component.css']
})
export class GetMyDataComponent implements OnInit {
  fileName = 'export-data.xlsx';
  hid:boolean=true;
  patientData!:Patient;
  firstName!:string;
  lastName!:string;
  abc!:string;
  patientDetailsFromLogin!:PatientRegistration;
  list:string[]=["Bhushan","sonu","Priyanka","Mansi","Parag"];
  constructor(private patientService:PatientService) { }

  ngOnInit(): void {
  
    this.patientDetailsFromLogin = JSON.parse(sessionStorage.getItem('patientDetails') || '{}');
    console.log("PAtient Details from login: ", this.patientDetailsFromLogin);

    this.patientService.getPatientDetailsById(this.patientDetailsFromLogin.patientId).subscribe(d=>
      {
        this.patientData=d;
      //   this.PatientDataForTable = d.allergy;
      // console.log('welocome to allergy mapping');
      // this.dataSource.data = this.PatientDataForTable;
      })
    
    
  }
  
  getExcelData() {
    // this.firstName=this.patientService.getFirstName();
    // this.lastName=this.patientService.getLastName();
    // console.log(this.firstName+ " "+"we are from get my data");
    // this.patientService.getByFirstNameAndLastName(this.fileName,this.lastName).subscribe(data=>{
    //   this.patientData=data;
      
    // });
   
    let element = document.getElementById('excel-id');
    const ws: XLXS.WorkSheet = XLXS.utils.table_to_sheet(element);
   
    const wb: XLXS.WorkBook = XLXS.utils.book_new();
    XLXS.utils.book_append_sheet(wb, ws, 'Patient Details');

    XLXS.writeFile(wb, this.fileName);

    //generate  pdf

  //   let doc = new jsPDF();
  //   let data = document.getElementById("content")
  //  this.generatePdf(data);
    
   }
   generatePdf(data:any){
    html2canvas(data).then(canvas =>{
      // let imgWidth =200;
      // let imgHeight = (canvas.height * imgWidth/ canvas.width)
      // let imgHeight = (canvas.height * imgWidth/ canvas.width)
      const contentDataUrl = canvas.toDataURL('image/png')
      let pdf = new jsPDF('p','pt','a4');
      // let imgWidth = 270;
      // let pageHeight = pdf.internal.pageSize.height;
      // let imgHeight = (canvas.height * imgWidth) / canvas.width;
      // var width = pdf.internal.pageSize.getWidth();
// var height = pdf.internal.pageSize.getHeight();
      // let heightLeft = imgHeight;
      // let position = 10
      const imgProps= pdf.getImageProperties(contentDataUrl);
      const pdfWidth = pdf.internal.pageSize.getWidth();
      const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;
      pdf.addImage(contentDataUrl, 'PNG', 0, 0, pdfWidth, pdfHeight);
      // var position = 10;
      // pdf.addImage(contentDataUrl,'JPEG',0,0,width,height);
      pdf.save("PatientInfo.pdf");
    })
  }
}
