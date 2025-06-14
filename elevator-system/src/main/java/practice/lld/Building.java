package practice.lld;

public class Building {
    private String name;
    private int numOfFloors;
    private ElevatorController elevatorController;

    public Building(String name, int numOfFloors,int numOfElevators) {
        this.name = name;
        this.numOfFloors = numOfFloors;
        this.elevatorController = new ElevatorController(numOfElevators);
    }
    public String getName() {
        return name;
    }
    public int getNumOfFloors() {
        return numOfFloors;
    }
    public ElevatorController getElevatorController() {
        return elevatorController;
    }
}
