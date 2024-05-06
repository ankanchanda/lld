public class Slot {

    private String parkingLotId;
    private Integer floorNumber;
    private Integer slotId;
    private Boolean isAvailable;
    private VehicleType asscociatedVehicleType;
    private Vehicle vehicle;

    public Slot(String parkingLotId, Integer floorNumber, Integer slotId, VehicleType asscociatedVehicleType) {
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        this.slotId = slotId;
        this.asscociatedVehicleType = asscociatedVehicleType;
        this.isAvailable = true;
        this.vehicle = null;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public VehicleType getAsscociatedVehicleType() {
        return asscociatedVehicleType;
    }

    public void bookSlot(Vehicle vehicle){
        this.vehicle = vehicle;
        isAvailable = false;
    }

    public void releaseSlot(){
        vehicle = null;
        isAvailable = true;
    }

    public Vehicle getAllocatedVehicle(){
        return vehicle;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public String getParkingLotId(){
        return parkingLotId;
    }
    
}
