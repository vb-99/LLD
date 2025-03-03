package practice.lld;


public class ElevatorSystemDemo {
    public static void main(String[] args) throws InterruptedException {
        ElevatorController controller = new ElevatorController(3, 2);

        controller.requestElevator(5, 6);
        Thread.sleep(2000);
        controller.requestElevator(3, 7);
        Thread.sleep(2000);
        controller.requestElevator(8, 2);
        Thread.sleep(5000);
        controller.requestElevator(6, 2);
    }
}