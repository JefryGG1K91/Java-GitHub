package xperiment.service.department.showalldepartment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xperiment.model.department.Deparment;
import xperiment.repository.department.DepartmentRepository;

@Service
public class ShowAllDepartmentServiceImpl implements ShowAllDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Deparment> getAllDepartment() {
		return departmentRepository.getAllDepartment();
	}

	@Override
	public List<Deparment> getAllNameDepartment() {
		return departmentRepository.getAllNameDepartment();
	}

	
	
	
}
