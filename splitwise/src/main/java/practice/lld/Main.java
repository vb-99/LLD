package practice.lld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create users
        User alice = new User("u1", "Alice", "alice@example.com");
        User bob = new User("u2", "Bob", "bob@example.com");
        User charlie = new User("u3", "Charlie", "charlie@example.com");

        // Create an expense manager and balance sheet
        ExpenseManager expenseManager = new ExpenseManager();
        BalanceSheet balanceSheet = new BalanceSheet();


        // Create and add users to a list for expenses
        List<User> participants = new ArrayList<>();
        participants.add(alice);
        participants.add(bob);
        participants.add(charlie);

        // Alice pays for dinner - Create an equal split expense
        Split equalSplit = SplitFactory.createSplit("EQUAL");
        Map<String, Object> splitDetails = new HashMap<>();
        Map<User, Double> dinnerShares = equalSplit.calculateSplit(60.0, participants, splitDetails);

        Expense dinnerExpense = new Expense("e1", "Dinner", 60.0, alice, dinnerShares, participants);

        // Add the expense to the expense manager which will notify observers
        expenseManager.addExpense(dinnerExpense);
        balanceSheet.onExpenseAdded(dinnerExpense);

        // Bob pays for movie tickets - Create a percentage split expense
        Map<String, Object> percentageSplitDetails = new HashMap<>();
        Map<User, Double> percentages = new HashMap<>();
        percentages.put(alice, 40.0);
        percentages.put(bob, 30.0);
        percentages.put(charlie, 30.0);
        percentageSplitDetails.put("percentages", percentages);

        Split percentageSplit = SplitFactory.createSplit("PERCENTAGE");
        Map<User, Double> movieShares = percentageSplit.calculateSplit(45.0, participants, percentageSplitDetails);

        Expense movieExpense = new Expense("e2", "Movie", 45.0, bob, movieShares,participants);

        // Add the movie expense to the expense manager
        expenseManager.addExpense(movieExpense);
        balanceSheet.onExpenseAdded(movieExpense);


        // Get individual balances
        System.out.println("Individual balances:");
        System.out.println("Alice's total balance: $" + balanceSheet.getTotalBalance(alice));
        System.out.println("Bob's total balance: $" + balanceSheet.getTotalBalance(bob));
        System.out.println("Charlie's total balance: $" + balanceSheet.getTotalBalance(charlie));

        // Print specific balances between users
        System.out.println("Pairwise balances:");
        System.out.println("Alice and Bob: $" + balanceSheet.getBalance(alice, bob));
        System.out.println("Alice and Charlie: $" + balanceSheet.getBalance(alice, charlie));
        System.out.println("Bob and Charlie: $" + balanceSheet.getBalance(bob, charlie));

        // Get the simplified settlements
        List<Transaction> settlements = balanceSheet.getMinimumSettlements();
        System.out.println("Settlements:");
        for (Transaction settlement : settlements) {
            System.out.println(settlement.getFrom().getName() + " pays " +
                    settlement.getTo().getName() + " $" +
                    settlement.getAmount());
        }
    }
}