import java.util.ArrayList;
import java.util.List;

public class Floor {
    
    private String parkingLotId;
    private Integer floorNumber;
    List<Slot> slots;

    Floor(String parkingLotId, Integer floorNumber, Integer slotsCount){
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        slots = new ArrayList<>();
        addASlot(VehicleType.TRUCK);
        addSlots(Math.min(slotsCount - 1, 2), VehicleType.BIKE);
        addSlots(Math.max(0, slotsCount - 3), VehicleType.CAR);
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public List<Slot> getSlots(){
        return slots;
    }

    public Integer getTotalSlots() {
        return slots.size();
    }

    public Integer getAvailableSlotsCountByVehicleType(VehicleType vehicleType){
        
        List<Slot> availableSlots = getSlotsAvailableByVehcicleType(vehicleType);
        return availableSlots.size();
    }

    public List<Slot> getSlotsAvailableByVehcicleType(VehicleType vehicleType){

        List<Slot> availableSlots = new ArrayList<>();

        for(Slot slot: slots){
            VehicleType slotVehicleType = slot.getAsscociatedVehicleType();
            Boolean isSlotAvailable = slot.isAvailable();

            if(isSlotAvailable && slotVehicleType.equals(vehicleType)){
                availableSlots.add(slot);
            }
        }

        return availableSlots;
    }

    public boolean isSlotsAvailableForVehcicleType(VehicleType vehicleType){
        Integer availableSlotsCount =  getAvailableSlotsCountByVehicleType(vehicleType);
        return availableSlotsCount > 0;
    }

    public void addSlots(Integer additionalSlots, VehicleType vehicleType){
        for(int i=0; i<additionalSlots; i++){
            addASlot(vehicleType);
        }
    }

    public void addASlot(VehicleType vehicleType){
        Integer slotId = getTotalSlots() + 1;
        slots.add(new Slot(floorNumber, slotId, vehicleType));
    }
    
}
