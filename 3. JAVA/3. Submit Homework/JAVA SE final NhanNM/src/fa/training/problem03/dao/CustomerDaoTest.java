package fa.training.problem03.dao;

import fa.training.problem03.models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class CustomerDaoTest {
    private CustomerDao customerDao;

    @BeforeEach
    public void setup() {
        customerDao = new CustomerDao();

    }
    @Test
    public void testSave() throws SQLException {
        Customer customer1 = new Customer();
        customer1.setId(1001);
        customer1.setFullname("Nguyen Van A");
        customer1.setAddress("District 1");
        customer1.setPhonenumber("090123456");
        customer1.setAge(20);
        String rs =  customerDao.save(customer1);
        Assertions.assertEquals(rs,"success");
    }

    @Test
    public void testUpdate() throws SQLException {
        String rs =  customerDao.update();
        Assertions.assertEquals(rs,"success");
    }

}
