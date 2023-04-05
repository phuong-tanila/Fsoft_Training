package fa.training.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		if (sessionFactory == null) {
			sessionFactory = cfg.buildSessionFactory();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		System.out.println(getSessionFactory());
	}
}

//public class HibernateUtil {
//	private static SessionFactory sessionFactory;
//
//	public static synchronized SessionFactory getSessionFactory() {
//		if (sessionFactory == null || !sessionFactory.isOpen()) {
//			Configuration configure = new Configuration().configure();
//			sessionFactory = configure.buildSessionFactory();
//		}
//		return sessionFactory;
//	}
//
//	public static void main(String[] args) {
//		System.out.println(getSessionFactory());
//	}
//}