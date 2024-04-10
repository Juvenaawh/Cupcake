package app.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems = new ArrayList<CartItem>();

    public void addItem(Topping topping, Bottom bottom, int quantity) {
         CartItem cartItem = new CartItem(bottom, topping, quantity);
          cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public int getCartCount()
    {
        return cartItems.size();
    }

    public int getTotalPrice()
    {
        int sum = 0;
        for (CartItem cartItem : cartItems) {
            sum += cartItem.getPrice();
        }
        return sum;
    }
}
