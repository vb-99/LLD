package practice.lld;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String,Account> accountsMap;
    public BankingService() {
        accountsMap = new ConcurrentHashMap<>();
    }
    public Account getAccountFromCard(Card card) {
        return accountsMap.get(card.getAccountFromCard().getAccountNumber());
    }
    public Account addAccount(Account account) {
        accountsMap.put(account.getAccountNumber(), account);
        return account;
    }
    public void removeAccount(String accountNumber) {
        accountsMap.remove(accountNumber);
    }
    public void processTransaction(Transaction transaction) {
        transaction.execute();
    }
}
