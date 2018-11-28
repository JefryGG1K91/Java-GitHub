package xperiment.services.employee.removedemployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xperiment.model.employee.Employee;
import xperiment.repository.employee.EmployeeRepository;

@Service
@Transactional(readOnly=true)
public class RemovedEmployeeServImpl implements RemovedEmployeeServices {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	@Transactional
	public void removeEmployee(Employee employee) {

		repository.delete(employee);
		
	}

}
