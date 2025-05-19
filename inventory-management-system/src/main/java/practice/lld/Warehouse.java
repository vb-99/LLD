package practice.lld;

import practice.lld.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private int id;
    private String name;
    private String location;
    private Map<String, Product> products;

    public Warehouse(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        if(products.containsKey(product.getSku())){
            int currentQuantity = getProductBySku(product.getSku()).getQuantity();
            int updatedQuantity = currentQuantity + quantity;
            getProductBySku(product.getSku()).setQuantity(updatedQuantity);
        } else{
            product.setQuantity(quantity);
            products.put(product.getSku(), product);
        }
    }
    public void removeProduct(Product product, int quantity){
       if(products.containsKey(product.getSku())){
           Product currentProduct = getProductBySku(product.getSku());
           int currentQuantity = currentProduct.getQuantity();
           if(currentQuantity < quantity){
               products.remove(product.getSku());
           } else{
               product.setQuantity(currentQuantity - quantity);
           }
           products.remove(product.getSku());
       } else{
           System.out.println("Product not found");
       }
    }

    public Product getProductBySku(String sku){
        return products.get(sku);
    }

    public List<Product> getProducts(){
        return  List.copyOf(products.values());
    }

}
