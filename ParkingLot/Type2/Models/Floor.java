package Models;
import java.util.List;

public class Floor {

    private String parkingLotId;
    private Integer floorNumber;
    private List<Slot> slots;

    public Floor(String parkingLotId, Integer floorNumber, List<Slot> slots){
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public Integer getTotalSlots() {
        return slots.size();
    }
}
