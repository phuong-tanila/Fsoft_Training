package fa.training.bean.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jndi.support.SimpleJndiBeanFactory;

public class Client {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("diConstructor.xml");
		Address add = (Address) context.getBean("addr");
		Employee emp3 = (Employee) context.getBean("emp3");
		System.out.println("Address details: " + add);
		System.out.println("Employee details: " + emp3);
	}
}
