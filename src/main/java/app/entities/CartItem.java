package app.entities;

public class CartItem {
    private int bottomId;
    private int toppingId;
    private int quantity;

    public CartItem(int bottomId, int toppingId, int quantity){
        this.bottomId = bottomId;
        this.toppingId = toppingId;
        this.quantity = quantity;
    }
    //Der laves getters & setters her;
    public int getBottomId(){
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
