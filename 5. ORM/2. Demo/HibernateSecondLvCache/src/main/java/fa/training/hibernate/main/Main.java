package fa.training.hibernate.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

import fa.training.hibernate.dao.EmployeeDAO;
import fa.training.hibernate.dao.impl.EmployeeDaoImpl;
import fa.training.hibernate.model.Employee;
import fa.training.hibernate.utils.HibernateUtils;

public class Main {
	public static void main(String[] args) {
//		// Demo First Level Cache
//		Session sessionA = null, sessionB = null;
//
//		sessionA = HibernateUtils.getSessionFactory().openSession();
//		sessionB = HibernateUtils.getSessionFactory().openSession();
//
//		Employee empl = (Employee) sessionA.load(Employee.class, new Integer(1));
//		System.out.println(empl.getFirstName());
//
//		// Lấy thêm lần nữa
//		empl = (Employee) sessionA.load(Employee.class, new Integer(1));
//
//		// ktra xem empl có nằm trong session hay ko thì dùng session.contain();
//		System.out.println(sessionA.contains(empl)); // trong session đã có tạo ra empl
//
//		System.out.println(empl.getFirstName());
//		System.out.println(sessionA.contains(empl));
//
//		// lấy thêm nhiều lần nữa
////		for (int i = 0; i < 5; i++) {
////			empl = (Employee) session.load(Employee.class, new Integer(1));
////			System.out.println(empl.getFirstName());
////		}
//		empl = (Employee) sessionB.load(Employee.class, new Integer(1));
//		System.out.println(empl.getFirstName());
//
//		// Xóa bỏ khỏi session - hay First Level Cache
//		sessionA.evict(empl);
//		// session.clear();
//
//		empl = (Employee) sessionA.load(Employee.class, new Integer(1));
//		System.out.println(empl.getFirstName());

//		//Demo lv2 Cache
//		Session sessionA = null, sessionB = null;
//		try {
//			sessionA = HibernateUtils.getSessionFactory().openSession();
//			sessionB = HibernateUtils.getSessionFactory().openSession();
//			
//			Employee empl = (Employee) sessionA.load(Employee.class, new Integer(1));
//			System.out.println(empl.getFirstName());
//			
//			//Lấy đối tượng employee trong sessionA
//			empl = (Employee) sessionA.load(Employee.class, new Integer(1));
//			System.out.println(empl.getFirstName());
//			
//			//Lấy đối tượng employee trong sessionB
//			empl = (Employee) sessionB.load(Employee.class, new Integer(1));
//			System.out.println(empl.getFirstName());
//			
//		}finally{
//			if(sessionA != null) {
//				sessionA.close();
//			}
//			if(sessionB != null) {
//				sessionB.close();
//			}
//		}

		// Demo Query Cache
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		List<Employee> list = session.createQuery( "select e " + "from Employee e " +
				"where e.id = :ID") .setParameter( "ID", 1)
				.setCacheable(true) .list();
		
		for (Employee employee : list) {
			System.out.println(employee.getFirstName());
		}
	}
}
