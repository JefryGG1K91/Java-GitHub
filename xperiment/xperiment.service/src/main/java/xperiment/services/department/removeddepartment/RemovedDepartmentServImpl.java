package xperiment.services.department.removeddepartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xperiment.model.department.Deparment;
import xperiment.repository.department.DepartmentRepository;

@Service
public class RemovedDepartmentServImpl implements RemovedDepartmentServices {
	
	@Autowired
	private DepartmentRepository repository;

	@Override
	public void removedDepartment(Deparment department) {
		
		repository.delete(department);
		
	}

}
