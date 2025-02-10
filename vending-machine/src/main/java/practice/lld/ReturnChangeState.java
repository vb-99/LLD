package practice.lld;

public class ReturnChangeState implements VendingMachineState{
    VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertMoney(Money money) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product already dispensed. Please collect the change.");
    }

    @Override
    public void returnChange() {
        int change = vendingMachine.getTotalPayment()-vendingMachine.getSelectedProduct().getPrice();
        System.out.println("You have been returned " + change + " for " + vendingMachine.getSelectedProduct().getName());
        vendingMachine.resetVendingMachinePayment();
        vendingMachine.setSelectedProduct(null);
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }
}
