package practice.lld;

import java.util.HashMap;
import java.util.Map;

public class AtmInventory {
    private final Map<Cash,Integer> cashInventory;

    public AtmInventory() {
        cashInventory = new HashMap<>();
    }
    public void initializeInventory() {
        cashInventory.put(Cash.HUNDRED,5);
        cashInventory.put(Cash.FIFTY, 10);
        cashInventory.put(Cash.FIVE, 10);
        cashInventory.put(Cash.TEN, 10);
        cashInventory.put(Cash.TWENTY, 10);
        cashInventory.put(Cash.ONE,50);
    }
    public boolean isSufficientFundsAvailable(int amount){
        int totalBalance = 0;
        for(Map.Entry<Cash,Integer> entry: cashInventory.entrySet()){
            totalBalance += entry.getValue()*entry.getKey().getValue();
        }
        return totalBalance >= amount;
    }

    public Map<Cash,Integer> dispense(int amount) {
        if(isSufficientFundsAvailable(amount)){
            Map<Cash,Integer> dispensedCash = new HashMap<>();
            int tempAmount = amount;
            for(Cash cash: Cash.values()){
                if(tempAmount >= cash.getValue() && cash.getValue() > 0){
                    int number = tempAmount/cash.getValue();
                    dispensedCash.put(cash, number);
                    cashInventory.put(cash,cashInventory.get(cash) - number);
                    tempAmount -= number*cash.getValue();
                }
            }
            if(tempAmount > 0){
                for(Map.Entry<Cash,Integer> entry: dispensedCash.entrySet()){
                    cashInventory.put(entry.getKey(), cashInventory.get(entry.getKey()) +entry.getValue());
                }
                return null;
            }
            return dispensedCash;
        } else{
            return null;
        }
    }
    public void addCash(Cash cash,int count) {
        cashInventory.put(cash,cashInventory.get(cash) + count);
    }
}
