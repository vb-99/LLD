package practice.lld;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Building building = new Building("Building1", 10,3);
        ElevatorDisplay elevatorDisplay = new ElevatorDisplay();
        ElevatorController elevatorController = building.getElevatorController();
        List<Elevator> elevators =elevatorController.getElevators();
        for(Elevator elevator : elevators){
            elevator.addObserver(elevatorDisplay);
        }
        ElevatorRequest request1 = new ElevatorRequest(1,3,Direction.UP,false);
        elevatorController.requestElevator(request1);
        elevatorController.requestFloor(1, 2);
        while(true) {
            elevatorController.step();
        }


    }
}