package com.DAO;

import com.model.Cart;
import com.model.CartItem;
import com.model.CustomerOrder;

public interface CartItemDAO {
void saveOrUpdateCartItem(CartItem cartItem);

void removeCartItem(int cartItemId);

Cart getCart(int cartId);

CustomerOrder createOrder(Cart cart);
}
