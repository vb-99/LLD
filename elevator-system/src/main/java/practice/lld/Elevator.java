package practice.lld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private List<ElevatorObserver> observers;
    private Queue<ElevatorRequest> requests;

    public Elevator(int id) {
        this.id = id;
        this.observers = new ArrayList<>();
        this.requests = new LinkedList<>();
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }
    public Queue<ElevatorRequest> getRequests() {
        return requests;
    }

    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(ElevatorObserver observer) {
        observers.remove(observer);
    }
    public void notifyElevatorStateChange(ElevatorState oldState,ElevatorState newState) {
        for (ElevatorObserver observer : observers) {
            observer.onElevatorStateChanged(oldState, newState);
        }
    }
    private void notifyElevatorFloorChanged(int oldFloor, int newFloor){
        for (ElevatorObserver observer : observers) {
            observer.onElevatorFloorChanged(oldFloor, newFloor);
        }
    }
    public void addRequest(ElevatorRequest request) {
        requests.add(request);
        if(this.getState() == ElevatorState.IDLE){
            if(request.getFloor() > this.getCurrentFloor()){
               setDirection(Direction.UP);
            } else {
                setDirection(Direction.DOWN);
            }
            setState(ElevatorState.MOVING);
        }
    }

    public void moveToNextStop(int nextSTop){
        if(this.getState() == ElevatorState.IDLE){
            return;
        }
        notifyElevatorFloorChanged(currentFloor, nextSTop);
        while(currentFloor != nextSTop){
            if(direction == Direction.UP){
                currentFloor++;
            } else{
                currentFloor--;
            }
            if(currentFloor == nextSTop){
                completeArrival();
            }
        }
    }

    private void completeArrival(){
        System.out.println("Elevator completed arriving at the destination");
        notifyElevatorStateChange(ElevatorState.MOVING, ElevatorState.STOPPED);
        setState(ElevatorState.STOPPED);
        requests.removeIf(elevatorRequest -> elevatorRequest.getFloor() == this.getCurrentFloor());
        if(requests.isEmpty()){
            notifyElevatorStateChange(ElevatorState.STOPPED, ElevatorState.IDLE);
            direction = Direction.IDLE;
            setState(ElevatorState.IDLE);
        } else{
            setState(ElevatorState.MOVING);
        }
    }
}
