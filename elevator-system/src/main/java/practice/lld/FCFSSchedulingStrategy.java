package practice.lld;

import java.util.Queue;

public class FCFSSchedulingStrategy implements SchedulingStrategy {

    @Override
    public int getNextSTop(Elevator elevator) {
        int currentFloor = elevator.getCurrentFloor();
        Queue<ElevatorRequest> requests = elevator.getRequests();
        if(requests.isEmpty()){
            return currentFloor;
        }
        int nextFloorToStop = requests.poll().getFloor();
        if(nextFloorToStop == currentFloor){
            return nextFloorToStop;
        }
        if(elevator.getDirection() == Direction.IDLE){
            elevator.notifyElevatorStateChange(elevator.getState(), ElevatorState.MOVING);
            elevator.setDirection(nextFloorToStop > currentFloor ? Direction.UP : Direction.DOWN);
        } else if(elevator.getDirection() == Direction.UP && currentFloor > nextFloorToStop){
                elevator.setDirection(Direction.DOWN);

        } else if(currentFloor < nextFloorToStop) {
            elevator.setDirection(Direction.UP);
        }
        return nextFloorToStop;
    }
}
