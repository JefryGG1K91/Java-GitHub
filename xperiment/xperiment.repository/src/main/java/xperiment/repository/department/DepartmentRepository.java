package xperiment.repository.department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xperiment.model.department.Deparment;

@Repository
public interface DepartmentRepository extends JpaRepository<Deparment, Integer> {

	@Query("select d from Deparment d order by d.departmentName")
	List<Deparment> getAllDepartment();
	
	@Query("select d.departmentName from Deparment d order by d.departmentName")
	List<Deparment> getAllNameDepartment();
	
	
}