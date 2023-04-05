package fa.training.restfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.restfulapi.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
