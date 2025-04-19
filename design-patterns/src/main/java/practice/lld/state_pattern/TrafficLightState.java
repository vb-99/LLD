package practice.lld.state_pattern;

public interface TrafficLightState {

    void next(TrafficLightContext context);

    String getColor();
}
