package practice.lld;

public interface AtmState {
    public AtmState nextState(AtmMachineContext context);
}
