package practice.lld;

import practice.lld.product.Product;

public interface InventoryObserver {
    public void update(Warehouse warehouse, Product product);
}
