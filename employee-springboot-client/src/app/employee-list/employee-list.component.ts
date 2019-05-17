import { Component, OnInit, Output } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeService } from '../employee.service';
import { Employee } from '../model/Employee';
import { EmployeeDetailsComponent } from '../employee-details/employee-details.component';


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})

export class EmployeeListComponent implements OnInit {

  employees: Observable<Employee[]>;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
// tslint:disable-next-line: variable-name
   this.employees = this.employeeService.getEmployeeList();
  }

  deleteEmployee(id: string) {

    this.employeeService.deleteEmployee(id).
      subscribe(
        data => {
          console.log(data);
          this.reloadData();
          },
           error => console.log(error));
  }
}
