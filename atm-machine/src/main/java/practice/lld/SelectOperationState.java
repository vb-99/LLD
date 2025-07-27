package practice.lld;

public class SelectOperationState implements AtmState {

    @Override
    public AtmState nextState(AtmMachineContext context) {
        if(context.getCard() == null){
            System.out.println("No card inserted");
            return context.getIdleState();
        }
        return context.getOperationState();
    }
}
