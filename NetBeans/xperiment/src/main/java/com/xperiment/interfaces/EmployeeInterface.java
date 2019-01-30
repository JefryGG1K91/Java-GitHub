/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xperiment.interfaces;

import com.xperiment.entity.Employee;
import java.util.List;

/**
 *
 * @author jgutierrez
 */
public interface EmployeeInterface {
    
    public void insertEmployee(Employee emp);
    public void updateEmployee(Employee emp);
    public void deleteEmployee(Employee emp);
    public List<Employee> getAllEmployee();
    
}
