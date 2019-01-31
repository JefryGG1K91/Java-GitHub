/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xperiment.service;

import com.xperiment.entity.Employee;
import com.xperiment.employee.dao.EmployeeInterface;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jgutierrez
 */

@Stateless
public class EmployeeServiceImp implements EmployeeInterfaceLocal, EmployeeInterfaceRemote{

    @EJB
    private EmployeeInterface ei;
   
    @Override
    public void insertEmployee(Employee emp) {

        ei.insertEmployee(emp);

    }

    @Override
    public void updateEmployee(Employee emp) {
        ei.updateEmployee(emp);
    }

    @Override
    public void deleteEmployee(Employee emp) {
       ei.deleteEmployee(emp);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return ei.getAllEmployee();
    }
    
    
    
    
}
