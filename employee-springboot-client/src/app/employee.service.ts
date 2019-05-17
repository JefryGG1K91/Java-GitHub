import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Observer } from 'rxjs';
import { Employee } from './model/Employee';


@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  private baseUrl = 'http://localhost:8080/rest/api/employee';

  constructor(private http: HttpClient) { }

  getEmployeeList(): Observable<Employee[]>  {
    return this.http.get<Employee[]>(`${this.baseUrl}`);
  }

// tslint:disable-next-line: ban-types
  getEmployeeById(id: string): Observable<Employee> {
      return this.http.get<Employee>(`${this.baseUrl}/${id}`);
  }

// tslint:disable-next-line: ban-types
  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  deleteEmployee(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType : 'text'});
}

// tslint:disable-next-line: ban-types
  updateEmployee(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  

  }
