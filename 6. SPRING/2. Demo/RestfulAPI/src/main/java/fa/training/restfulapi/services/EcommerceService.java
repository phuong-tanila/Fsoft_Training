package fa.training.restfulapi.services;

import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.restfulapi.entities.Order;
import fa.training.restfulapi.entities.Product;
import fa.training.restfulapi.entities.ProductGroup;
import fa.training.restfulapi.entities.ProductImage;
import fa.training.restfulapi.repositories.GroupRepository;
import fa.training.restfulapi.repositories.OrderRepository;
import fa.training.restfulapi.repositories.ProductRepository;

@Service
public class EcommerceService {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	GroupRepository groupRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProduct(long id) {
		return productRepository.findById(id);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public String addProductImage(final String productId, final String filename) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		ProductImage image = new ProductImage();
		image.setProductId(Long.parseLong(productId));
		image.setPath(filename);

		try {
			String res = session.save(image).toString();
			session.getTransaction().commit();
			return res;
		} catch (HibernateException e) {
			System.out.print(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return "";
	}

	public List<ProductGroup> getGroups() {
		return groupRepository.findAll();
	}

	public Optional<ProductGroup> getGroup(long id) {
		return groupRepository.findById(id);
	}

	public ProductGroup saveGroup(ProductGroup group) {
		return groupRepository.save(group);
	}

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrder(long id) {
		return orderRepository.findById(id);
	}

	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
}
