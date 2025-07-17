package practice.lld;

public class Seat {
    private final int seatNumber;
    private final SeatCategory seatCategory;

    public Seat(int seatNumber, SeatCategory seatCategory) {
        this.seatNumber = seatNumber;
        this.seatCategory = seatCategory;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public double getPrice() {
        switch(seatCategory){
            case PLATINUM -> {
                return 100;
            }
            case GOLD -> {
                return 50;
            }
            case SILVER -> {
                return 20;
            }
            default -> {
                return 0;
            }
        }
    }


}
