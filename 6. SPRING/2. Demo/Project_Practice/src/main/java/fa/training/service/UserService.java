package fa.training.service;

import fa.training.dao.UserDAO;
import fa.training.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public Users checkLogin(final Users users) {

        return userDAO.checkLogin(users);
    }
}
