package practice.lld.states;

import practice.lld.VendingMachineContext;

public class HasMoneyState implements VendingMachineState {
    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(context.getCurrencyList().isEmpty()) {
            System.out.println("No money added");
            return new IdleState();
        }
        return new ProductSelectionState();
    }
}
