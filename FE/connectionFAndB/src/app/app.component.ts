import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'connectionFAndB';  
  employeeForm = new FormGroup({
    name: new FormControl(''),
    age: new FormControl(''),
  })

  constructor(private http:HttpClient) {

  }  

  ngOnInit(): void {  
    
  }  

  onSubmit() {  
    this.http.post<Object>('http://localhost:8080/api/employees', this.employeeForm.value)
    .subscribe({
      next: (response:any) => {console.log("Employee Info: ",response)},
      error: (error:any) => {console.log("Error: ", error)}
    })
  }  
  getEmployees(){
    this.http.get<Object>('http://localhost:8080/api/employees')
    .subscribe({
      next: (response:any) => {console.log("Employees: ",response)},
      error: (error:any) => {console.log("Error: ", error)}
    })
  }
}
