package practice.lld;

public class ReadyState implements VendingMachineState {
    VendingMachine vendingMachine;

    ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("A product has already been selected");
    }

    @Override
    public void insertMoney(Money money) {
        vendingMachine.setTotalPayment(money);
        if(vendingMachine.getSelectedProduct().getPrice() <= vendingMachine.getTotalPayment()){
            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        } else{
            System.out.println("You don't have enough money");
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please insert the money");
    }

    @Override
    public void returnChange() {
        System.out.println("Please insert the money");
    }
}
