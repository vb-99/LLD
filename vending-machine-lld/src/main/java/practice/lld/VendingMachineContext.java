package practice.lld;

import practice.lld.states.*;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineContext {
    private VendingMachineState currentState;
    private Inventory inventory;
    private List<Currency> currencyList;
    private ItemType selectedItemType;

    public VendingMachineContext() {
        this.currentState = new IdleState();
        this.inventory = new Inventory();
        this.currencyList = new ArrayList<>();
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void nextState() {
        this.currentState = currentState.next(this);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }
    public void clearCurrency() {
        this.currencyList.clear();
    }

    public void addCurrency(List<Currency> currency) {
        this.currencyList = currency;
    }

    public double getBalance() {
        double balance = 0;
        for (Currency currency : currencyList) {
            balance += currency.getValue();
        }
        return balance;
    }

    public ItemType getSelectedItemType() {
        return selectedItemType;
    }

    public void setSelectedItemType(ItemType selectedItemType) {
        this.selectedItemType = selectedItemType;
    }

    public double getSelectedItemPrice(){
        return inventory.getItemPrice(selectedItemType);
    }


    public void insertCoins(List<Currency> currency) {
        if (currentState instanceof IdleState) {
            this.currencyList = currency;
            System.out.println("Inserted currency worth " + getBalance());
            nextState();
        }
    }

    public void selectProduct(ItemType itemType){
        if(this.currentState instanceof HasMoneyState){
            System.out.println("Selected product of type " + itemType);
            this.selectedItemType = itemType;
            nextState();
            if(currentState instanceof ProductSelectionState){
                nextState();
                if(currentState instanceof ReturnChangeState){
                    nextState();
                } else{
                    dispenseProduct();
                }
            }
        } else{
            System.out.println("Please insert coins before selecting a product");
        }
    }

    public void dispenseProduct(){
        if(this.currentState instanceof DispenseState){
            System.out.println("Dispensing product of type " + selectedItemType);
            inventory.removeItemFromShelf(selectedItemType,1);
            nextState();
        } else{
            System.out.println("Please select a product before dispensing");
        }
    }

    public void returnChange(){
        nextState();
    }

}
