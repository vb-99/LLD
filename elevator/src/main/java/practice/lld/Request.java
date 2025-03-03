package practice.lld;

public class Request {
    private final int sourceFloor;
    private final int destinationFloor;

    public Request(int source, int destination) {
        this.sourceFloor = source;
        this.destinationFloor = destination;
    }

    @Override
    public String toString() {
        return ("source: " + sourceFloor + ", destination: " + destinationFloor);
    }
    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
