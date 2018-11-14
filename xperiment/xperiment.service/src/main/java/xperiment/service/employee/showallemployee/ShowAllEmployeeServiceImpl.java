package xperiment.service.employee.showallemployee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xperiment.model.employee.Employee;
import xperiment.repository.employee.EmployeeRepository;

@Service
public class ShowAllEmployeeServiceImpl implements ShowAllEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.getAllEmployee();
	}

	
	
	
}
