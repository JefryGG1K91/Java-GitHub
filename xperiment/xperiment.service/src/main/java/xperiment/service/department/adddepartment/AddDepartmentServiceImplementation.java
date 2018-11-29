package xperiment.service.department.adddepartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xperiment.model.Deparment;
import xperiment.repository.department.DepartmentRepository;

@Service
@Transactional(readOnly=true)
public class AddDepartmentServiceImplementation implements AddDepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	@Transactional
	public void save(Deparment departmentDAO) {
		
		Deparment departmentInstance= new Deparment();
		departmentInstance.setDepartmentName(departmentDAO.getDepartmentName());
		departmentInstance.setDepartmentLocation(departmentDAO.getDepartmentLocation());
		
		repository.save(departmentInstance);
		
	}

}
