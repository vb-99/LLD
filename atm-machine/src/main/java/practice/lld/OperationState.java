package practice.lld;

public class OperationState implements AtmState{
    @Override
    public AtmState nextState(AtmMachineContext atmMachineContext) {
        if(atmMachineContext.getCard() == null){
            System.out.println("Card is not inserted");
            return atmMachineContext.getIdleState();
        }
        atmMachineContext.setOperation(null);
        return atmMachineContext.getSelectOperationState();
    }
}
