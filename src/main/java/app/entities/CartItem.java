package app.entities;

public class CartItem {
    private Bottom bottom;
    private Topping topping;
    private int quantity;

    public CartItem(Bottom bottom, Topping topping, int quantity) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
    }

    //Der laves getters

    public Bottom getBottom() {
        return bottom;
    }

    public int getQuantity() {
        return quantity;
    }

    public Topping getTopping() {
        return topping;
    }


    public int getPrice()
    {
        return quantity * (bottom.getPrice() + topping.getPrice());
    }
}
