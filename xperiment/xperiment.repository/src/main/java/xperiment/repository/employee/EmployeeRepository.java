package xperiment.repository.employee;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xperiment.model.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e order by e.name")
	List<Employee> getAllEmployee();
	
}
