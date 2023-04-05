package fa.training.restfulapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Optional;
import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

	private Integer id;
	private String price;

	private Order order;
	private Optional<Product> product;
	private GroupVariant groupVariant;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne
	@JoinColumn(name = "product_id")
	// @JsonBackReference(value = "product_reference")
	public Optional<Product> getProduct() {
		return product;
	}

	public void setProduct(Optional<Product> prod) {
		this.product = prod;
	}

	@ManyToOne
	@JoinColumn(name = "product_variant_id")
	public GroupVariant getGroupVariant() {
		return groupVariant;
	}

	public void setGroupVariant(GroupVariant groupVariant) {
		this.groupVariant = groupVariant;
	}
}
