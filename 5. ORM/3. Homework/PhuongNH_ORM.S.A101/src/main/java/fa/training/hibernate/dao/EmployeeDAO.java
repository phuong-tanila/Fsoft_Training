package fa.training.hibernate.dao;

import fa.training.hibernate.model.Employee;

public interface EmployeeDAO {
	public boolean save(Employee emp);

	public Employee findEmployeeById(Integer empId);

	public int updateFisrtName(Integer empId, String firstName);
	
	public boolean deleteEmployee(Integer empId);
}
