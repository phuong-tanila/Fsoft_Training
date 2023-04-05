package fa.training.restfulapi.controllers;

import fa.training.restfulapi.entities.Order;
import fa.training.restfulapi.hateoas.OrderModel;
import fa.training.restfulapi.services.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController extends CoreController {

	@Autowired
	private EcommerceService ecommerceService;
	@Autowired
	Validator orderValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(orderValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<OrderModel> index() {
		List<Order> orders = ecommerceService.getOrders();
		List<OrderModel> out = new ArrayList<OrderModel>();
		if (orders != null) {
			orders.forEach(o -> {
				OrderModel OrderModel = new OrderModel(o);
				OrderModel.add(createHateoasLink(o.getId()));

				out.add(OrderModel);
			});
		}
		return out;
	}

	@PostMapping
	public Order create(@RequestBody @Valid Order order) {

		// Required by Hibernate ORM to save properly
		if (order.getItems() != null) {
			order.getItems().forEach(item -> item.setOrder(order));
		}
		return ecommerceService.saveOrder(order);
	}

	@RequestMapping("/{id}")
	public OrderModel view(@PathVariable("id") long id) {
		OrderModel OrderModel = new OrderModel(ecommerceService.getOrder(id));
		OrderModel.add(createHateoasLink(id));
		return OrderModel;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Order edit(@PathVariable("id") long id, @RequestBody @Valid Order order) {

		Optional<Order> optionalUpdatedOrder = ecommerceService.getOrder(id);
		Order updatedOrder = optionalUpdatedOrder.get();

		if (updatedOrder == null) {
			return null;
		}

		return ecommerceService.saveOrder(updatedOrder);
	}
}
