package practice.lld;

import practice.lld.product.Product;

public class SupplierNotifier implements InventoryObserver{
    private final String supplierName;
    private final String supplierEmail;

    public SupplierNotifier(String supplierName, String supplierEmail) {
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
    }
    @Override
    public void update(Warehouse warehouse, Product product) {
        System.out.println("Sending email to " + supplierName + " with new product " + product.getName());
    }

}
