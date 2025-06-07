package practice.lld.states;

import practice.lld.VendingMachineContext;

public class IdleState implements VendingMachineState {
    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(!context.getCurrencyList().isEmpty()){
            return new HasMoneyState();
        }

       return this;
    }
}
