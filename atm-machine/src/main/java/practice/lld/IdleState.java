package practice.lld;

public class IdleState implements AtmState {

    @Override
    public AtmState nextState(AtmMachineContext context) {
       if(context.getCard() != null){
           return context.getHasCardState();
       }
       System.out.println("No card inserted");
       return this;
    }
}
