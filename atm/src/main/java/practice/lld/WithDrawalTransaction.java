package practice.lld;

public class WithDrawalTransaction extends Transaction {
    public WithDrawalTransaction(String transactionId,Account account,double amount) {
        super(transactionId,amount,account);
    }

    @Override
    public void execute() {
        account.withdraw(amount);
    }
}
