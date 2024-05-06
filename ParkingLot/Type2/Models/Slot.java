package Models;

import Enums.SlotStatus;
import Enums.VehicleType;

public class Slot {

    private Integer id;
    private String parkingLotId;
    private Integer floorNumber;
    private SlotStatus slotStatus;
    private VehicleType asscociatedVehicleType;

    public Slot(Integer id, String parkingLotId, Integer floorNumber, VehicleType asscociatedVehicleType, SlotStatus slotStatus) {
        this.id = id;
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        this.asscociatedVehicleType = asscociatedVehicleType;
        this.slotStatus = slotStatus;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public Integer getId() {
        return id;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

    public VehicleType getAsscociatedVehicleType() {
        return asscociatedVehicleType;
    }

    public void setAsscociatedVehicleType(VehicleType asscociatedVehicleType) {
        this.asscociatedVehicleType = asscociatedVehicleType;
    }
    
}
