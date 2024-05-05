import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    
    private String parkingLotId;
    List<Floor> floors; 

    public ParkingLot(String parkingLotId, Integer floorsCount, Integer slotsPerFloor) {
        this.parkingLotId = parkingLotId;
        floors = new ArrayList<>();
        for(int i=0; i<floorsCount; i++){
            floors.add(new Floor(parkingLotId, i, slotsPerFloor));
        }
    }

    void addFloors(Integer additionalFloors, Integer slotsPerFloor){
        for(int i=0; i<additionalFloors; i++){
            addFloor(slotsPerFloor);
        }
    }

    void addFloor(Integer slotsPerFloor){
        int floorNumber = floors.size();
        floors.add(new Floor(parkingLotId, floorNumber, slotsPerFloor));
    }

    public void addSlotsToFloor(Integer floorNumber, Integer additionalSlots, VehicleType vehicleType){
        Floor floor = floors.get(floorNumber);
        floor.addSlots(additionalSlots, vehicleType);
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public List<Floor> getAllFloors() {
        return floors;
    }

    public Integer getFloorsCount(){
        return floors.size();
    }

    public Integer getSlotsCountByFloorNumber(Integer floorNumber){
        Floor floor = floors.get(floorNumber);
        return floor.getTotalSlots();
    }

    public Integer getNumberOfFreeSlotsByVehicleType(VehicleType vehicleType){
        Integer freeSlotsCount = 0;
        for(Floor floor: floors){
            freeSlotsCount += floor.getAvailableSlotsCountByVehicleType(vehicleType);
        }

        return freeSlotsCount;
    }

    public List<Slot> getFreeSlotsByVehicleType(VehicleType vehicleType){
        List<Slot> availableSlots = new ArrayList<>();

        for(Floor floor: floors){
            if(floor.isSlotsAvailableForVehcicleType(vehicleType)){
                List<Slot> slots = floor.getSlotsAvailableByVehcicleType(vehicleType);
                slots.addAll(slots);
            }
        }

        return availableSlots;
    }

}
