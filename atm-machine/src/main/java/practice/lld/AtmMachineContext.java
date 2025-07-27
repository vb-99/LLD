package practice.lld;

import java.util.HashMap;
import java.util.Map;

public class AtmMachineContext {
    private AtmState currentState;
    private OperationType operationType;
    private Map<String,Account> accounts;
    private Card  card;
    private final AtmInventory atmInventory;

    public AtmMachineContext() {
        this.atmInventory = new AtmInventory();
        this.accounts = new HashMap<>();
        this.currentState = new IdleState();
        atmInventory.initializeInventory();
    }
    public AtmState getCurrentState() {
        return currentState;
    }

    public void nextState() {
        currentState = currentState.nextState(this);

    }

    public void insertCard(Card card) {
        if(currentState instanceof IdleState) {
            this.card = card;
            nextState();
        } else{
            System.out.println("Card can only be inserted into state of IdleState");
        }
    }

    public void enterPin(String pin){
        if(currentState instanceof HasCardState ){
            if(card.validatePin(pin)){
                System.out.println("pin is valid");
                nextState();
            } else{
                System.out.println("pin is not valid");
            }
        } else{
            System.out.println("Card can only be inserted into state of HasCardState");
        }
    }
    public void selectOperation(OperationType operationType) {
        if(currentState instanceof SelectOperationState){
            this.operationType = operationType;
            System.out.println("Operation type is " + operationType);
            nextState();
        } else{
            System.out.println("Operation type can only be inserted into state of OperationState");
        }
    }

    public void performOperation(int amount){
        if(currentState instanceof OperationState){
            if(this.operationType == OperationType.CHECK_BALANCE){
                System.out.println("Current account balance: " + this.card.getAccount().getBalance());
                nextState();
            } else if(this.operationType == OperationType.WITHDRAW_CASH){
                if(!atmInventory.isSufficientFundsAvailable(amount)){
                    System.out.println("Insufficient funds available in the atm");
                } else if(card.getAccount().getBalance() < amount){
                    System.out.println("Insufficient funds available in the account");
                } else {
                    Map<Cash, Integer> dispensedCash = atmInventory.dispense(amount);
                    if (dispensedCash != null) {
                        this.card.getAccount().withdraw(amount);
                        for (Map.Entry<Cash, Integer> entry : dispensedCash.entrySet()) {
                            System.out.println("Dispensed cash: " + entry.getKey() + " with value: " + entry.getValue());
                        }
                    } else {
                        System.out.println("No dispensed cash available");
                    }
                }
                nextState();

            }
        } else{
            System.out.println("Operation type can only be inserted into state of OperationState");
        }
    }
    public void returnCard() {
        this.card = null;
    }
    private void resetATM() {
        this.card = null;
        this.operationType = null;
        this.currentState = getIdleState();
    }
    public Card getCard() {
        return card;
    }
    public AtmState getIdleState() {
        return new IdleState();
    }
    public AtmState getHasCardState() {
        return new HasCardState();
    }
    public AtmState getSelectOperationState() {
        return new SelectOperationState();
    }
    public AtmState getOperationState() {
        return new OperationState();
    }
    public void setOperation(OperationType operationType) {
        this.operationType = operationType;
    }




}
