package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    private SchedulingStrategy schedulingStrategy;

    public ElevatorController(int numberOfElevators) {
        elevators = new ArrayList<>();
        schedulingStrategy = new FCFSSchedulingStrategy();
        for(int i=1;i<=numberOfElevators;i++) {
            this.elevators.add(new Elevator(i));
        }
    }

    public void setSchedulingStrategy(SchedulingStrategy schedulingStrategy) {
        this.schedulingStrategy = schedulingStrategy;
    }

    public void requestElevator(ElevatorRequest elevatorRequest) {
        Elevator elevator = getElevatorById(elevatorRequest.getElevatorId());
        elevator.addRequest(elevatorRequest);
    }

    public void requestFloor(int elevatorId,int floor){
        Elevator elevator = getElevatorById(elevatorId);
        Direction direction = elevator.getCurrentFloor() < floor ? Direction.UP : Direction.DOWN;
        elevator.addRequest(new ElevatorRequest(elevatorId,floor,direction,true));
    }

    private Elevator getElevatorById(int id){
        return elevators.stream().filter(elevator -> elevator.getId() == id).findFirst().orElse(null);
    }

    public void step(){
        for(Elevator elevator:elevators) {
            if(!elevator.getRequests().isEmpty()) {
                int nextFloor = schedulingStrategy.getNextSTop(elevator);
                if(elevator.getCurrentFloor() != nextFloor){
                    elevator.moveToNextStop(nextFloor);
                }
            }
        }
    }
    public List<Elevator> getElevators() {
        return elevators;
    }
}
