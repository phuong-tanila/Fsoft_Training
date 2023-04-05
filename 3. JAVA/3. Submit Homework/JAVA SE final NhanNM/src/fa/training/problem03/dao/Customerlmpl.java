package fa.training.problem03.dao;

import fa.training.problem03.models.Customer;

public class Customerlmpl {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.setId(1001);
        customer1.setFullname("Nguyen Van A");
        customer1.setAddress("District 1");
        customer1.setPhonenumber("0909123456");
        customer1.setAge(20);
        CustomerDao.getIntance().save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(1002);
        customer2.setFullname("Nguyen Van B");
        customer2.setAddress("District 2");
        customer2.setPhonenumber("0707333666");
        customer2.setAge(30);
        CustomerDao.getIntance().save(customer2);

        Customer customer3 = new Customer();
        customer3.setId(1003);
        customer3.setFullname("Nguyen Van C");
        customer3.setAddress("District 3");
        customer3.setPhonenumber("0505444555");
        customer3.setAge(25);
        CustomerDao.getIntance().save(customer3);

        Customer customer4 = new Customer();
        customer4.setId(1004);
        customer4.setFullname("Nguyen Van D");
        customer4.setAddress("District 4");
        customer4.setPhonenumber("060622333");
        customer4.setAge(33);
        CustomerDao.getIntance().save(customer4);

        Customer customer5 = new Customer();
        customer5.setId(1005);
        customer5.setFullname("Nguyen Van E");
        customer5.setAddress("District 1");
        customer5.setPhonenumber("0101444666");
        customer5.setAge(42);
        CustomerDao.getIntance().save(customer5);
    }
}
