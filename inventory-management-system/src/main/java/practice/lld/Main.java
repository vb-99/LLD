package practice.lld;

import practice.lld.product.Product;
import practice.lld.product.ProductCategory;
import practice.lld.product.ProductFactory;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of InventoryManager
        InventoryManager inventoryManager = InventoryManager.getInstance();

        // Create and add warehouses
        Warehouse warehouse1 = new Warehouse(1,"Warehouse 1","Location 1");
        Warehouse warehouse2 = new Warehouse(2,"Warehouse 2", "Location2");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        // Create products using ProductFactory
        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct("SKU123", "Laptop", 1000.0, 50,2,ProductCategory.ELECTRONICS);
        Product tShirt = productFactory.createProduct("SKU456", "T-Shirt", 20.0, 200,2,ProductCategory.CLOTHING);
        Product apple = productFactory.createProduct("SKU789", "Apple", 1.0, 100,1,ProductCategory.GROCERY);
        SupplierNotifier supplierNotifier = new SupplierNotifier("John", "abc@d.com");
        inventoryManager.addObserver(supplierNotifier);
        // Add products to warehouses
        warehouse1.addProduct(laptop,1);
        warehouse1.addProduct(tShirt,1);
        warehouse2.addProduct(apple,1);

        // Set the replenishment strategy to Just-In-Time
        inventoryManager.setReplenishmentStrategy(new JustInTimeReplenishment());



        // Replenish a specific product if needed
        inventoryManager.checkStockAndReplenish("SKU123");
    }
}
