package xperiment.services.employee.removedemployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xperiment.model.employee.Employee;
import xperiment.repository.employee.EmployeeRepository;

@Service
public class RemovedEmployeeServImpl implements RemovedEmployeeServices {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void removeEmployee(Employee employee) {

		repository.delete(employee);
		
	}

}
