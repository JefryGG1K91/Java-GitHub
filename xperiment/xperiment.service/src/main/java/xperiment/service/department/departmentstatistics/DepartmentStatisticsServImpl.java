package xperiment.service.department.departmentstatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xperiment.repository.department.DepartmentRepository;

@Service
@Transactional(readOnly=true)
public class DepartmentStatisticsServImpl implements DepartmentStatisticsServ {

	@Autowired
	private DepartmentRepository repository;
	
	@Override
	@Transactional
	public Integer getNumOfEmployeeForDepartment(Integer departmentId) {

		return repository.getNumOfEmployeeForDepartment(departmentId);
	
	}

}
