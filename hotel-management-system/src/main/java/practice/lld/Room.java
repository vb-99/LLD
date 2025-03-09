package practice.lld;

public class Room {
    private final String roomId;
    private final RoomType roomType;
    private RoomStatus roomStatus;
    private final double price;

    public Room(String roomId, RoomType roomType, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.roomStatus = RoomStatus.AVAILABLE;
    }
    public void book(){
        if(roomStatus == RoomStatus.AVAILABLE){
            roomStatus = RoomStatus.BOOKED;
        } else{
            throw new IllegalStateException("Room is not available to book");
        }
    }
    public void checkIn(){
        if(roomStatus == RoomStatus.BOOKED){
            roomStatus = RoomStatus.OCCUPIED;
        } else{
            throw new IllegalStateException("Room is not booked");
        }
    }
    public void checkOut(){
        if(roomStatus == RoomStatus.OCCUPIED){
            roomStatus = RoomStatus.AVAILABLE;
        } else{
            throw new IllegalStateException("Room is not available to check out");
        }
    }

    public String getRoomId() {
        return roomId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public double getPrice() {
        return price;
    }
}
