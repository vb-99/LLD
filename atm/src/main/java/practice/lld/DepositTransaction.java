package practice.lld;

public class DepositTransaction extends Transaction {
    public DepositTransaction(String transactionId,Account account,double amount) {
        super(transactionId,amount,account);
    }
    @Override
    public void execute() {
        account.deposit(amount);
    }
}
