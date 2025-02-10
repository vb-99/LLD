package practice.lld;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Product, Integer> products;
    public Inventory() {
        products = new HashMap<Product, Integer>();
    }
    public void addProduct(Product product,int quantity){
        products.put(product,quantity);
    }
    public void removeProduct(Product product){
        products.remove(product);
    }
    public int getQuantity(Product product){
        return products.getOrDefault(product,0);
    }
    public void updateQuantity(Product product,int quantity){
        products.put(product,quantity);
    }

}
