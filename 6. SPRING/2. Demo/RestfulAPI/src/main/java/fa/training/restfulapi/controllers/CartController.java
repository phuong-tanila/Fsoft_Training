package fa.training.restfulapi.controllers;

import fa.training.restfulapi.cart.CartItem;
import fa.training.restfulapi.cart.CartService;
import fa.training.restfulapi.entities.Order;
import fa.training.restfulapi.hateoas.OrderModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.validation.Validator;
import java.util.Set;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
@RequestMapping("/cart")
public class CartController extends CoreController {

	@Autowired
	CartService cartService;

	@Autowired
	Validator orderValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(orderValidator);
	}

	@PostMapping("/")
	public String create() {
		return cartService.createNewCart();
	}

	@PostMapping("/{id}")
	public String addProduct(@PathVariable("id") String cartId, @RequestBody CartItem cartItem) {
		cartService.addProduct(cartId, cartItem);
		return "OK";
	}

	@GetMapping("/{id}")
	public Set<CartItem> getCartItems(@PathVariable("id") String cartId) {
		return cartService.getItems(cartId);
	}

	@DeleteMapping("{id}/{product_id}")
	public String removeItem(@PathVariable("id") String cartId, @PathVariable("product_id") String productId) {
		cartService.removeProduct(cartId, productId);
		return "OK";
	}

	@PostMapping("{id}/quantity")
	public String setProductQuantity(@PathVariable("id") String cartId, @RequestBody CartItem cartItem) {
		String productId = Long.toString(cartItem.getProductId());
		cartService.setProductQuantity(cartId, productId, cartItem.getQuantity());
		return "OK";
	}

	@PostMapping("{id}/order")
	public OrderModel createOrder(@PathVariable("id") String cartId, @RequestBody @Valid Order order) {
		if (order == null) {
			System.out.println("Order not in POST");
			return null;
		}
		OrderModel orderResource = new OrderModel(cartService.createOrder(cartId, order));
		// HAL link:
		Link link = WebMvcLinkBuilder.linkTo(OrderController.class).slash(order.getId()).withSelfRel();
		orderResource.add(link);
		if (orderResource.id < 1) {
			System.out.println("Resource not created");
			return null;
		}
		return orderResource;

	}
}
