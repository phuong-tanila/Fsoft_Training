package fa.training.hibernate.main;

import java.util.Iterator;

import org.hibernate.Session;

import fa.training.hibernate.dao.EmployeeDAO;
import fa.training.hibernate.dao.impl.EmployeeDaoImpl;
import fa.training.hibernate.model.Employee;
import fa.training.hibernate.utils.HibernateUtils;

public class Main {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDaoImpl();
		
//		Insert employee
		Employee emp = new Employee(3, "Tran", "Cong");
		empDao.save(emp);

//		Find employee by id
//		System.out.println(empDao.findEmployeeById(3));
		
//		Update first name  of employee by id
//		empDao.updateFisrtName(1, "Nguyen");
		
//		Delete employee by id
//		empDao.deleteEmployee(3);
		
		
	}
}
