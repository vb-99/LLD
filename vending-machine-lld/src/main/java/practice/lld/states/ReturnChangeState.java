package practice.lld.states;

import practice.lld.VendingMachineContext;

public class ReturnChangeState implements VendingMachineState{
    @Override
    public VendingMachineState next(VendingMachineContext context) {
        double returnAmount = context.getBalance() - context.getSelectedItemPrice();
        if(returnAmount > 0) {
            System.out.println("Returning change of " + returnAmount);
            context.setSelectedItemType(null);
            context.clearCurrency();
        }
        return new IdleState();
    }
}
