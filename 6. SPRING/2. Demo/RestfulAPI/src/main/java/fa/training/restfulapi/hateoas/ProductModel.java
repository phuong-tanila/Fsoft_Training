package fa.training.restfulapi.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import fa.training.restfulapi.entities.Product;
import org.springframework.hateoas.RepresentationModel;
import java.util.Optional;

public class ProductModel extends RepresentationModel<ProductModel> {
	@JsonProperty
	public long id;
	public String name;
	public String price;
	public String description;
	public Object group;

	public ProductModel(Optional<Product> optional) {
		setProduct(optional.get());
	}

	public ProductModel(Product product) {
	}

	private void setProduct(Product product) {
		name = product.getName();
		price = product.getPrice();
		description = product.getDescription();
		group = product.getGroup();
	}
}
