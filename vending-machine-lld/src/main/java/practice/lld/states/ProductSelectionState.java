package practice.lld.states;

import practice.lld.VendingMachineContext;

public class ProductSelectionState implements VendingMachineState {

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(context.getInventory().getQuantity(context.getSelectedItemType()) > 0){
            if(context.getInventory().getItemPrice(context.getSelectedItemType()) > context.getBalance()){
                System.out.println("Insufficient funds");
                return new HasMoneyState();
            }
            return new DispenseState();
        }
        System.out.println("Insufficient inventory");
        return new ReturnChangeState();

    }
}
