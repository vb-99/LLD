package practice.lld.product;

public class ProductFactory {
    public static Product createProduct(String sku, String name, double price, int quantity, int threshold, ProductCategory category){
        switch (category){
            case ELECTRONICS:
                return new ElectronicsProduct.ElectronicsProductBuilder(sku,name,price,quantity,threshold,category).build();
            case CLOTHING:
                return new ClothingProduct.ClothingProductBuilder(sku,name,price,quantity,threshold,category).build();
            case GROCERY:
                return new GroceryProduct.GroceryProductBuilder(sku,name,price,quantity,threshold,category).build();
            case FURNITURE:
        }
        return null;
    }
}
