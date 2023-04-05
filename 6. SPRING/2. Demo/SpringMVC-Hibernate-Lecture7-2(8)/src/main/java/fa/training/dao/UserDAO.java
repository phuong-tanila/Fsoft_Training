package fa.training.dao;

import fa.training.entities.Customer;
import fa.training.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
 

    public Users checkLogin(final Users users) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Query<Users> query = session.createQuery("FROM Users where userName = :userName and password = :password", Users.class);
            query.setParameter("userName", users.getUserName());
            query.setParameter("password", users.getPassword());
            Users singleResult = query.getSingleResult();
            return singleResult;
        } catch (Exception e) {
            return null;
        }
    }

}
