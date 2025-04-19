package practice.lld.state_pattern;

public class Main {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();
        trafficLight.nextState(); // RED -> GREEN
        trafficLight.nextState(); // GREEN -> YELLOW
        trafficLight.nextState(); // YELLOW -> RED
        trafficLight.nextState(); // RED -> GREEN
    }
}
