package fa.training.restfulapi.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import fa.training.restfulapi.entities.Order;
import fa.training.restfulapi.entities.OrderItem;
import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.RepresentationModel;

public class OrderModel extends RepresentationModel<GroupModel> {
	@JsonProperty
	public long id;
	public String name;
	public String address;
	public String city;
	public String zip;
	public String status;
	public String comment;
	public String totalPrice;
	public String type;
	public String created;
	public List<OrderItem> items;

	public OrderModel(Optional<Order> optional) {
		setOrder(optional.get());
	}

	public OrderModel(Order order) {
		setOrder(order);
	}

	private void setOrder(Order order) {
		name = order.getName();
		address = order.getAddress();
		city = order.getCity();
		zip = order.getZip();
		status = order.getStatus();
		comment = order.getComment();
		totalPrice = order.getTotalPrice();
		type = order.getType();
		created = order.getCreated();
		items = order.getItems();
	}
}
