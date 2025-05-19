package practice.lld;

import practice.lld.product.Product;
import practice.lld.product.ProductFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    private List<Warehouse> warehouses;
    private ReplenishmentStrategy replenishmentStrategy;
    private List<InventoryObserver> observers;

    private InventoryManager(){
        this.warehouses = new ArrayList<>();
        this.replenishmentStrategy = new JustInTimeReplenishment();
        this.observers = new ArrayList<>();
    }
    //for thread safety
    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addWarehouse(Warehouse warehouse){
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse){
        warehouses.remove(warehouse);
    }

    public void checkStockAndReplenish(String sku){
        for(Warehouse warehouse : warehouses){
            if(warehouse.getProductBySku(sku) != null){
                Product product = warehouse.getProductBySku(sku);
                notifyObservers(warehouse,product);
                if(product.getQuantity() < product.getThreshold() ){
                    this.replenishmentStrategy.replenish(warehouse,sku);
                }
            }
        }
    }
    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy){
        this.replenishmentStrategy = replenishmentStrategy;
    }
    public void addObserver(InventoryObserver observer){
        observers.add(observer);
    }
    public void removeObserver(InventoryObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(Warehouse warehouse,Product product){
        for(InventoryObserver observer : observers){
            observer.update(warehouse,product);
        }
    }



}
