package fa.training.utils;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
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
}
