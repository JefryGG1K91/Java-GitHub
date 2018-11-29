package xperiment.repository.department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xperiment.model.Deparment;

@Repository
public interface DepartmentRepository extends JpaRepository<Deparment, Integer> {

	@Query("select d from Deparment d order by d.departmentName")
	List<Deparment> getAllDepartment();
	
	@Query("select count(d) from Employee d where d.department.id =:departmentId")
	Integer getNumOfEmployeeForDepartment(@Param("departmentId") Integer departmentId);
	//"SELECT p From Person p WHERE p.id= :id where d.department= :department_id"
}