package practice.lld;

public class DispenseState implements VendingMachineState{
    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("A product has already been selected");
    }

    @Override
    public void insertMoney(Money money) {
        System.out.println("Money has already been paid");
    }

    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.getSelectedProduct();
       vendingMachine.getInventory().updateQuantity(product,vendingMachine.getInventory().getQuantity(product)-1);
       System.out.println("Dispensed product " + product.getName());
       vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }
}
