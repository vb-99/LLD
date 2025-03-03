package practice.lld;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int capacity;
    private final int id;
    @Getter
    private int currentFloor;
    @Getter
    private Direction currentDirection;
    private final List<Request> requests;

    public Elevator(int id,int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 0;
        this.currentDirection = Direction.IDLE;
        this.requests = new ArrayList<>();
    }

    public synchronized void addRequest(Request request) {
       if(requests.size() < capacity) {
           requests.add(request);
           System.out.println("Adding request " + request + " to elevator " + id);
           notifyAll();
       }

    }
    public synchronized Request getNextRequest() {
        if(requests.isEmpty()){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return requests.remove(0);
    }

    public synchronized void processRequests(){
        while(true) {
            while (requests.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Request request = getNextRequest();
            processRequest(request);
        }

    }

    public void processRequest(Request request) {
        int startFloor = currentFloor;
        int endFloor = request.getDestinationFloor();
        if (startFloor < endFloor) {
            currentDirection = Direction.UP;
            for (int i = startFloor; i <= endFloor; i++) {
                currentFloor = i;
                System.out.println("Elevator " + id + " reached floor " + currentFloor);
                try {
                    Thread.sleep(1000); //simulating elevator movement between teh floors
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (startFloor > endFloor) {
            currentDirection = Direction.DOWN;
            for (int i = startFloor; i >= endFloor; i--) {
                currentFloor = i;
                System.out.println("Elevator " + id + " reached floor " + currentFloor);
                try {
                    Thread.sleep(1000); //simulating elevator movement between teh floors
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        currentDirection= Direction.IDLE;
    }

    public void run(){
        processRequests();
    }


}
