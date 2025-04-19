package practice.lld.state_pattern;

public class GreenLightState implements TrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("green light being changed to yellow light");
        context.setCurrentState(new YellowLightState() );
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}
