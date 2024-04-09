package app.persistence;

import app.entities.CartItem;
import java.util.HashMap;
import java.util.Map;

public class CartMapper {

    /*private Map<String, CartItem> items = new HashMap<>();

    public static void addItem(int bottomId, int toppingId, int quantity){
        String key = generateKey(bottomId, toppingId);
        CartItem item = items.getOrDefault(key, new CartItem(bottomId,toppingId,0));
        item.setQuantity(item.getQuantity()+quantity);
        items.put(key, item);
    }
    public void removeItem(int bottomId, int toppingId){
        String key = generateKey(bottomId, toppingId);
        items.remove(key);
    }
    public double getSubtotal(Map<Integer, Double> bottomPrices, Map<Integer, Double> toppingPrices){
        //Stream er en command i java, som er god fordi, den kan udtrykke komplekse dataer, med mindre kode på en mere læsælig måde.
        return items.values().stream().mapToDouble(item ->(bottomPrices.getOrDefault(item.getBottomId(),0.0)+toppingPrices.getOrDefault(item.getToppingId(), 0.0))* item.getQuantity()).sum();
    }

    private String generateKey(int bottomId, int toppingId) {
        return bottomId + ":" + toppingId;
    }

    //Denne metoden bruges til at få alle varer i kurven
    public Map<String, CartItem>getItems(){
        return items;
    }*/

}
