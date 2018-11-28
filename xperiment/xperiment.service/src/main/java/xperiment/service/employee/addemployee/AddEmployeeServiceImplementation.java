package xperiment.service.employee.addemployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xperiment.model.employee.Employee;
import xperiment.repository.employee.EmployeeRepository;

@Service
@Transactional(readOnly=true)
public class AddEmployeeServiceImplementation implements AddEmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Transactional
	public void save(Employee employeeDAO) {
		
		Employee employeInstance= new Employee();
		employeInstance.setName(employeeDAO.getName());
		employeInstance.setLastname(employeeDAO.getLastname());
		employeInstance.setBirthDay(employeeDAO.getBirthDay());
		employeInstance.setDepartment(employeeDAO.getDepartment());
		repository.save(employeInstance);
		
	}

}
