package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachineContext vendingMachine = new VendingMachineContext();
        System.out.println("|");
        System.out.println("Filling up the inventory");
        System.out.println("|");
        vendingMachine.getInventory().addItemToShelf(ItemType.COKE, 10, 30);
        vendingMachine.getInventory().addItemToShelf(ItemType.PEPSI, 7, 40);
        vendingMachine.getInventory().addItemToShelf(ItemType.SODA, 7, 20);
        vendingMachine.getInventory().addItemToShelf(ItemType.JUICE, 20, 10);

        // Insert coins using the context methods
        List<Currency> money = new ArrayList<>();
        money.add(Currency.TWENTY);
        money.add(Currency.TWENTY);
        vendingMachine.insertCoins(money);
        System.out.println("|");
        System.out.println("Clicking on ProductSelectionButton");
        System.out.println("|");
        // Start product selection and choose a product
        vendingMachine.selectProduct(ItemType.COKE);
        vendingMachine.returnChange();



    }
}