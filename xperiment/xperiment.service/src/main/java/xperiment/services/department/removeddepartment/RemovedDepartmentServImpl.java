package xperiment.services.department.removeddepartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xperiment.model.department.Deparment;
import xperiment.repository.department.DepartmentRepository;

@Service
@Transactional(readOnly=true)
public class RemovedDepartmentServImpl implements RemovedDepartmentServices {
	
	@Autowired
	private DepartmentRepository repository;

	@Override
	@Transactional
	public void removedDepartment(Deparment department) {
		
		repository.delete(department);
		
	}

}
