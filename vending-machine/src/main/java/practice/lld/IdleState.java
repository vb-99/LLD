package practice.lld;

public class IdleState implements VendingMachineState {

    VendingMachine vendingMachine;

    IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        vendingMachine.setSelectedProduct(product);
        System.out.println("Selected product: " + product.getName());
        vendingMachine.setCurrentState(vendingMachine.getReadyState());
    }

    @Override
    public void insertMoney(Money money) {
        System.out.println("Select a product before!");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select a product before!");

    }

    @Override
    public void returnChange() {
        System.out.println("Select a product before!");
    }
}
