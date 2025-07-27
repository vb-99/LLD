package practice.lld;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account account1 = new Account("123456", 1000);
        Account account2 = new Account("654321", 500);
        AtmMachineContext atm = new AtmMachineContext();

        System.out.println("=== Starting ATM Demo ===");

        // Insert card
        atm.insertCard(new Card("123456", "1234", account1));

        // Enter PIN
        atm.enterPin("1234");

        // Select operation
        atm.selectOperation(OperationType.WITHDRAW_CASH);

        // Perform transaction
        atm.performOperation(85);

        // Select another operation
        atm.selectOperation(OperationType.CHECK_BALANCE);

        // Perform balance check
        atm.performOperation(0);

        // Return card
        atm.returnCard();

        System.out.println("=== ATM Demo Completed ===");
    }
}