package fa.training.restfulapi.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;

import fa.training.restfulapi.entities.GroupVariant;
import fa.training.restfulapi.entities.ProductGroup;
import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.RepresentationModel;

public class GroupModel extends RepresentationModel<GroupModel> {
	@JsonProperty
	public long id;
	public String groupName;
	public String price;
	public List<GroupVariant> variants;

	public GroupModel(Optional<ProductGroup> optional) {
		setGroup(optional.get());
	}

	public GroupModel(ProductGroup productGroup) {
		setGroup(productGroup);
	}

	private void setGroup(ProductGroup productGroup) {
		this.id = productGroup.getId();
		this.groupName = productGroup.getGroupName();
		this.price = productGroup.getPrice();
		this.variants = productGroup.getGroupVariants();
	}
}
