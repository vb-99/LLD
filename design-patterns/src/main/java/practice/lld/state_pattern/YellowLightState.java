package practice.lld.state_pattern;

public class YellowLightState implements TrafficLightState {

        @Override
        public void next(TrafficLightContext context) {
            System.out.println("yellow light being changed to red light");
            context.setCurrentState(new RedLightState());
        }

        @Override
        public String getColor() {
            return "YELLOW";
        }

}
