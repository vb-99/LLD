package practice.lld;

import java.util.*;

public class BalanceSheet {
    private Map<UserPair, Double> balances;

    public BalanceSheet() {
        balances = new HashMap<>();
    }

    private void updateBalances(Expense expense) {
        User payer = expense.getPayer();
        Map<User, Double> shares = expense.getShares();
        for (Map.Entry<User, Double> entry : shares.entrySet()) {
            User participant = entry.getKey();
            Double amount = entry.getValue();
            if (!participant.equals(payer)) {
                UserPair userPair = new UserPair(participant, payer);
                Double balance = balances.getOrDefault(userPair, 0.0);
                balances.put(userPair, balance + amount);

            }

        }

    }

    public void onExpenseAdded(Expense expense) {
        updateBalances(expense);
    }

    public void onExpenseUpdated(Expense expense) {
        updateBalances(expense);
    }

    public double getBalance(User user1, User user2) {
        UserPair pair1 = new UserPair(user1, user2);
        UserPair pair2 = new UserPair(user2, user1);
        double balance1 = balances.getOrDefault(pair1, 0.0);
        double balance2 = balances.getOrDefault(pair2, 0.0);
        return balance1 - balance2;
    }

    public double getTotalBalance(User user) {
        double total = 0.0;
        for (Map.Entry<UserPair, Double> entry : balances.entrySet()) {
            UserPair userPair = entry.getKey();
            Double balance = entry.getValue();
            User user1 = userPair.getUser1();
            User user2 = userPair.getUser2();
            if (user1.equals(user)) {
                total -= balance;
            } else if (user2.equals(user)) {
                total += balance;
            }

        }
        return total;
    }

    public List<Transaction> getMinimumSettlements() {
        List<Transaction> transactions = new ArrayList<>();
        Map<User, Double> netBalances = new HashMap<>();
        for (Map.Entry<UserPair, Double> entry : balances.entrySet()) {
            UserPair userPair = entry.getKey();
            Double balance = entry.getValue();
            User user1 = userPair.getUser1();
            User user2 = userPair.getUser2();
            netBalances.put(user1, netBalances.getOrDefault(user1, 0.0) - balance);
            netBalances.put(user2, netBalances.getOrDefault(user2, 0.0) + balance);
        }
        List<UserBalance> creditList = new ArrayList<>();
        for (Map.Entry<User, Double> entry : netBalances.entrySet()) {
            creditList.add(new UserBalance(entry.getKey(), entry.getValue()));
        }
        List<Transaction> minTransactionLogs = new ArrayList<>();
        dfs(0, creditList, creditList.size(), new ArrayList<>(), minTransactionLogs);
        return minTransactionLogs;


    }

    public void dfs(int currentIndex, List<UserBalance> creditList, int n, List<Transaction> currentTransactionLogs, List<Transaction> minimumTransactionLogs) {
        if (currentIndex < n && creditList.get(currentIndex).getBalance() == 0) {
            currentIndex++;
        }
        if (currentIndex == n) {
            if (minimumTransactionLogs.isEmpty() || currentTransactionLogs.size() < minimumTransactionLogs.size()) {
                minimumTransactionLogs.clear();
                minimumTransactionLogs.addAll(currentTransactionLogs);
            }
            return;
        }
        for (int i = currentIndex + 1; i < n; i++) {
            User creditor, debitor;
            double transactionAmount;
            if (creditList.get(currentIndex).getBalance() * creditList.get(i).getBalance() < 0) {
                if (creditList.get(currentIndex).getBalance() > 0) {
                    creditor = creditList.get(currentIndex).getUser();
                    debitor = creditList.get(i).getUser();

                } else {
                    creditor = creditList.get(i).getUser();
                    debitor = creditList.get(currentIndex).getUser();
                }
                transactionAmount = Math.abs(creditList.get(currentIndex).getBalance() - creditList.get(i).getBalance());
                Transaction transaction = new Transaction(UUID.randomUUID().toString(), debitor, creditor, transactionAmount);
                creditList.get(i).setBalance(creditList.get(i).getBalance() + creditList.get(currentIndex).getBalance());
                currentTransactionLogs.add(transaction);
                dfs(currentIndex + 1, creditList, n, currentTransactionLogs, minimumTransactionLogs);
                creditList.get(i).setBalance(creditList.get(i).getBalance() - creditList.get(currentIndex).getBalance());
                currentTransactionLogs.removeLast();
            }
        }
    }


}





