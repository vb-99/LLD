package practice.lld;

public interface VendingMachineState {
  public void selectProduct(Product product);
  public void insertMoney(Money money);
  public void dispenseProduct();
  public void returnChange();

}
