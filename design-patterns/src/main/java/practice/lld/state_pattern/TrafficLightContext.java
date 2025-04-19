package practice.lld.state_pattern;

public class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext() {
        currentState = new RedLightState();
    }
    public void setCurrentState(TrafficLightState newState) {
      currentState = newState;
    }
    public void nextState() {
        currentState.next(this);
    }
}
