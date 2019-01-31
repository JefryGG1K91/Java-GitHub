/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xperiment.bean;

import com.xperiment.entity.Employee;
import com.xperiment.employee.dao.EmployeeInterface;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jgutierrez
 */
@ManagedBean(name = "employeeBean")
@RequestScoped
public class EmployeeManageBean {

    @EJB
    private EmployeeInterface ei;

    private Employee employee;

    private List<Employee> employees;

    public EmployeeManageBean() {
    }

    @PostConstruct
    public void init() {
//     public EmployeeManageBean(){
        this.employee = new Employee();
        this.employees = ei.getAllEmployee();
    }

    public void insertEmployee() {
        Employee emp = new Employee();
        emp.setEmployeName(this.employee.getEmployeName());
        emp.setEmployeLastname(this.employee.getEmployeLastname());
        ei.insertEmployee(emp);
    }

    /**
     * @return the employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
