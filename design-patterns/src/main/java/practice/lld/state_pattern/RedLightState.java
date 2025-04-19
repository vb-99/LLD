package practice.lld.state_pattern;

public class RedLightState implements TrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("red light being changed to green light");
        context.setCurrentState(new GreenLightState());
    }

    @Override
    public String getColor() {
        return "RED";
    }
}
