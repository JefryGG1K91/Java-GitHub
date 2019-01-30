/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xperiment.bussines.implementation;

import com.xperiment.entity.Employee;
import com.xperiment.interfaces.EmployeeInterface;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jgutierrez
 */

@Stateless
public class EmployeePersistenUnit implements EmployeeInterface{

    private static EntityManager em;
    private static EntityTransaction et;
    private static final String PERSISTEN_UNIT="com.xperiment";
    
    public EmployeePersistenUnit(){
        em = Persistence.createEntityManagerFactory(PERSISTEN_UNIT).createEntityManager();
        et = em.getTransaction();
    }
    
    @Override
    public void insertEmployee(Employee emp) {

        try {
            et.begin();
            em.persist(emp);
            et.commit();
        } catch (Exception e) {
            System.out.println("com.xperiment.bussines.implementation.EmployeePersistenUnit.insertEmployee() "+e.getMessage());
        }

    }

    @Override
    public void updateEmployee(Employee emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEmployee(Employee emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAllEmployee() {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }
    
    
    
    
}
