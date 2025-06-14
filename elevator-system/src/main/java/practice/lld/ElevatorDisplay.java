package practice.lld;

public class ElevatorDisplay implements ElevatorObserver{

    @Override
    public void onElevatorStateChanged(ElevatorState oldState, ElevatorState newState) {
        System.out.println("Elevator State Changed from " +oldState + " to " + newState );
    }

    @Override
    public void onElevatorFloorChanged(int oldFloor, int newFloor) {
        System.out.println("Elevator Floor Changed from " + oldFloor + " to " + newFloor );
    }
}
