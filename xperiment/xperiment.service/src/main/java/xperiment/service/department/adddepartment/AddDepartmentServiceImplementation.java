package xperiment.service.department.adddepartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xperiment.model.department.Deparment;
import xperiment.repository.department.DepartmentRepository;

@Service
public class AddDepartmentServiceImplementation implements AddDepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	public void save(Deparment departmentDAO) {
		
		Deparment departmentInstance= new Deparment();
		departmentInstance.setDepartmentName(departmentDAO.getDepartmentName());
		departmentInstance.setDepartmentLocation(departmentDAO.getDepartmentLocation());
		
		repository.save(departmentInstance);
		
	}

}
