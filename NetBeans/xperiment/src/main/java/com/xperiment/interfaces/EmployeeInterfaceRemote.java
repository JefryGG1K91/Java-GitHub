/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xperiment.interfaces;

import com.xperiment.entity.Employee;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jgutierrez
 */
@Remote
public interface EmployeeInterfaceRemote {
    
    public void insertEmployee(Employee emp);
    public void updateEmployee(Employee emp);
    public void deleteEmployee(Employee emp);
    public List<Employee> getAllEmployee();
    
}
