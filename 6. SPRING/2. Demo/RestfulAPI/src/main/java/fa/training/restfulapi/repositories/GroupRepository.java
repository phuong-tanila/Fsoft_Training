package fa.training.restfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fa.training.restfulapi.entities.ProductGroup;

@Repository("groupRepository")
public interface GroupRepository extends JpaRepository<ProductGroup, Long> {
}
