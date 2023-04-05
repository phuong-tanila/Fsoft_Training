package fa.training.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.User;
import fa.training.utils.DBUtils;
import fa.training.utils.LogFactory;

public class UserDao {
	public boolean registerUser(User user) {
		Session session = DBUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		if (user == null) {
			return false;
		}
		try {
			session.saveOrUpdate(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LogFactory.getLogger().error("An exception occurs while register user");
			return false;
		} finally {
			session.close();
		}

	}
}
