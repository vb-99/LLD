package practice.lld.states;

import practice.lld.VendingMachineContext;

public interface VendingMachineState {
    VendingMachineState next( VendingMachineContext context);
}
