package practice.lld;

public abstract class Transaction {
    final String transactionId;
    final double amount;
    final Account account;

    public Transaction(String transactionId, double amount, Account account) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.account = account;
    }
    public abstract void execute();
}
