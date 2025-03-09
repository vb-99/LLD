package practice.lld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class Atm {
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;
    private AtomicLong transactionCounter;

    public Atm(BankingService bankingService,CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
        transactionCounter = new AtomicLong(0);
    }
    public boolean authenticateUser(Card card){
        return true;
    }
    public double checkBalance(Card card){
        return bankingService.getAccountFromCard(card).getBalance();
    }

    public void withdrawCash(Card card,double amount){
        Account account = bankingService.getAccountFromCard(card);
        if(account != null && account.getBalance() < amount){
            System.out.println("Insufficient funds");
            return;
        }
        Transaction transaction = new WithDrawalTransaction(generateTransactionId(),account,amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash(amount);

    }
    public void depositCash(Card card,double amount){
        Account account = bankingService.getAccountFromCard(card);
        Transaction transaction = new DepositTransaction(generateTransactionId(),account,amount);
        bankingService.processTransaction(transaction);
    }
    private String generateTransactionId() {
        // Generate a unique transaction ID
        long transactionNumber = transactionCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN" + timestamp + String.format("%010d", transactionNumber);
    }

}
