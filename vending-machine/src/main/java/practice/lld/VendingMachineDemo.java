package practice.lld;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = new Product("Coke", 140);
        Product pepsi = new Product("Pepsi", 225);
        Product water = new Product("Water", 200);

        vendingMachine.getInventory().addProduct(coke, 5);
        vendingMachine.getInventory().addProduct(pepsi, 3);
        vendingMachine.getInventory().addProduct(water, 2);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coins
        vendingMachine.addMoney(Money.FIFTY);
        vendingMachine.addMoney(Money.HUNDRED);


        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();


        // Select another product
        vendingMachine.selectProduct(pepsi);

        // Insert insufficient payment
        vendingMachine.addMoney(Money.FIFTY);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more coins
        vendingMachine.addMoney(Money.HUNDRED);
        vendingMachine.addMoney(Money.HUNDRED);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();
    }
}