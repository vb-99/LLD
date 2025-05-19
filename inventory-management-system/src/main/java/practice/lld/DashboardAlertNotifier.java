package practice.lld;

import practice.lld.product.Product;

import java.util.List;

public class DashboardAlertNotifier implements InventoryObserver{
    private List<String> adminUsers;

    @Override
    public void update(Warehouse warehouse,Product product) {
        double stockPercentage = (double) product.getQuantity() / product.getThreshold() * 100;
        if(stockPercentage <= 25 ){
          System.out.println("CRITICAL ALERT: " + product.getName()
                + " stock critically low at " + product.getQuantity() + " units ("
                + String.format("%.1f", stockPercentage) + "% of threshold)");
        notifyAdmins(product, "CRITICAL");
        } else if (stockPercentage <= 50) {
            // Warning alert - yellow notification
            System.out.println("WARNING ALERT: " + product.getName()
                    + " stock low at " + product.getQuantity() + " units ("
                    + String.format("%.1f", stockPercentage) + "% of threshold)");
            notifyAdmins(product, "WARNING");
        }
        }

    public void notifyAdmins(Product product, String level){
        for(String adminUser : adminUsers){
            System.out.println("Dashboard notification sent to admin: " + adminUser
                    + " - " + level + " level alert for " + product.getName());
        }
    }
}
