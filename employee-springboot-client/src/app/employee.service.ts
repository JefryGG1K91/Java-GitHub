import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Observer } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  private baseUrl: 'http://localhost:8080/rest/api/employees';

  constructor(private http: HttpClient) { }

  getEmployeeList(): Observable<any>  {
    return this.http.get(`${this.baseUrl}`);
  }

// tslint:disable-next-line: ban-types
  getEmployeeById(id: number): Observable<Object> {
      return this.http.get(`${this.baseUrl}/${id}`);
  }

// tslint:disable-next-line: ban-types
  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType : 'text'});
}

// tslint:disable-next-line: ban-types
  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }


  }
