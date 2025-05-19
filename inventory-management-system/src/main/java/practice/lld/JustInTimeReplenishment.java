package practice.lld;

public class JustInTimeReplenishment implements ReplenishmentStrategy{
    @Override
    public void replenish(Warehouse warehouse, String sku) {
        // Implement Just-In-Time replenishment logic
        System.out.println("Applying Just-In-Time replenishment for " + sku);
        // Calculate optimal order quantity based on demand rate
    }
}
