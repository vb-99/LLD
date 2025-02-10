package practice.lld;

public class VendingMachine {
    private static VendingMachine instance;
    private final Inventory inventory;
    private final VendingMachineState readyState;
    private final VendingMachineState idleState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private Integer totalPayment;
    private Product selectedProduct;

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        totalPayment = 0;
        selectedProduct = null;
    }
    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }
    public void selectProduct(Product product){
        currentState.selectProduct(product);
    }
    public void setSelectedProduct(Product product) {
      this.selectedProduct = product;
    }
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }
    public void returnChange(){
        currentState.returnChange();
    }
    public void addMoney(Money money) {
        currentState.insertMoney(money);
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    public void setCurrentState(VendingMachineState state){
        this.currentState = state;
    }
    public Integer getTotalPayment() {
        return totalPayment;
    }
    public void setTotalPayment(Money money) {
        this.totalPayment += money.getValue();
    }
    public Inventory getInventory(){
        return inventory;
    }

    public void resetVendingMachinePayment(){
        totalPayment = 0;
    }



}
