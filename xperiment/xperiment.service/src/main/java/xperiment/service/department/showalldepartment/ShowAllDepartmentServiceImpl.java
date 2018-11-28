package xperiment.service.department.showalldepartment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xperiment.model.department.Deparment;
import xperiment.repository.department.DepartmentRepository;

@Service
@Transactional(readOnly=true)
public class ShowAllDepartmentServiceImpl implements ShowAllDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	@Transactional
	public List<Deparment> getAllDepartment() {
		return departmentRepository.getAllDepartment();
	}

		
}
