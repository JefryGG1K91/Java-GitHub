package xperiment.service.employee.showallemployee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xperiment.model.employee.Employee;
import xperiment.repository.employee.EmployeeRepository;

@Service
@Transactional(readOnly=true)
public class ShowAllEmployeeServiceImpl implements ShowAllEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeRepository.getAllEmployee();
	}

	
	
	
}
