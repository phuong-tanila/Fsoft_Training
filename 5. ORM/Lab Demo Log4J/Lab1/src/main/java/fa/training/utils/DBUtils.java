package fa.training.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtils {
	private static SessionFactory sessionFactory;

	static {
		// Create a new Configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		// Get the SessionFactory object from Configuration
		if (sessionFactory == null) {
			sessionFactory = cfg.buildSessionFactory();
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
