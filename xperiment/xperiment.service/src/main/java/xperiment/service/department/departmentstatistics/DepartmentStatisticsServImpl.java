package xperiment.service.department.departmentstatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xperiment.repository.department.DepartmentRepository;

@Service
public class DepartmentStatisticsServImpl implements DepartmentStatisticsServ {

	@Autowired
	private DepartmentRepository repository;
	
	@Override
	public Integer getNumOfEmployeeForDepartment(Integer departmentId) {

		return repository.getNumOfEmployeeForDepartment(departmentId);
	
	}

}
