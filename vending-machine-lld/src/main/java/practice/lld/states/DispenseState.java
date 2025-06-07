package practice.lld.states;

import practice.lld.VendingMachineContext;

public class DispenseState implements VendingMachineState{
    @Override
    public VendingMachineState next(VendingMachineContext context) {
        System.out.println("Dispensed " + context.getSelectedItemType());
        return new ReturnChangeState();
    }
}
