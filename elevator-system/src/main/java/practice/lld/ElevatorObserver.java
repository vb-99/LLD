package practice.lld;

public interface ElevatorObserver {
    void onElevatorStateChanged(ElevatorState oldState,ElevatorState newState);
    void onElevatorFloorChanged(int oldFloor,int newFloor);
}
