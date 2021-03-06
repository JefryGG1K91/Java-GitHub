package com.javaexample.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaexample.model.Employee;
import com.javaexample.repository.EmployeeRepository;;

@Service
public class AddEmployeeServiceImplementation implements AddEmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public void save(Employee employeeDAO) {
		
		Employee employeInstance= new Employee();
		employeInstance.setName(employeeDAO.getName());
		employeInstance.setLastname(employeeDAO.getLastname());
		employeInstance.setBirthDay(employeeDAO.getBirthDay());
		repository.save(employeInstance);
		
	}


}
