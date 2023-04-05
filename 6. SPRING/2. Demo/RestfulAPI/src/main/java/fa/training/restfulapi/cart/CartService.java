package fa.training.restfulapi.cart;

import java.util.Set;
import fa.training.restfulapi.entities.Order;

public interface CartService {
	public String createNewCart();

	public void addProduct(String cartId, CartItem cartItem);

	public void removeProduct(String cartId, String productId);

	public void setProductQuantity(String cartId, String productId, int quantity);

	public Set<CartItem> getItems(String cartId);

	public Order createOrder(String cartId, Order order);
}
