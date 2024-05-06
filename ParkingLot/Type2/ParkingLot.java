import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParkingLot {
    
    private String parkingLotId;
    List<Floor> floors; 

    public ParkingLot(String parkingLotId, Integer floorsCount, Integer slotsPerFloor) {
        this.parkingLotId = parkingLotId;
        floors = new ArrayList<>();
        for(int i=0; i<floorsCount; i++){
            floors.add(new Floor(parkingLotId, i + 1, slotsPerFloor));
        }
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
        Floor floor = floors.get(floorNumber - 1);
        return floor.getTotalSlots();
    }

    public Map<Integer, Integer> getFreeSlotsCountByVehicleType(VehicleType vehicleType){
        Map<Integer, Integer> freeSlotsCount = new TreeMap<>();
        for(Floor floor: floors){
            Integer availableSlots = floor.getAvailableSlotsCountByVehicleType(vehicleType);
            if(availableSlots > 0){
                freeSlotsCount.put(floor.getFloorNumber(), availableSlots);
            }
        }

        return freeSlotsCount;
    }

    public List<Slot> getFreeSlotsInFloorByVehicleType(Integer floorNumber, VehicleType vehicleType){
        Floor floor = floors.get(floorNumber - 1);
        List<Slot> freeSlots = floor.getSlotsAvailableByVehcicleType(vehicleType);
        return freeSlots;
    }

    public Map<Integer, List<Slot>> getFreeSlotsByVehicleType(VehicleType vehicleType){
        Map<Integer, List<Slot>> availableSlots = new TreeMap<>();

        for(Floor floor: floors){
            List<Slot> slots = floor.getSlotsAvailableByVehcicleType(vehicleType);
            availableSlots.put(floor.getFloorNumber(), slots);
        }

        return availableSlots;
    }

    public Map<Integer, List<Slot>> getOccupiedSlots(VehicleType vehicleType){

        Map<Integer, List<Slot>> occupiedSlots = new TreeMap<>();
        for(Floor floor: floors){
            List<Slot> slots = floor.getOccupiedSlotsByVehicleType(vehicleType);
            occupiedSlots.put(floor.getFloorNumber(), slots);
        }
        return occupiedSlots;
    }

    void addFloors(Integer additionalFloors, Integer slotsPerFloor){
        for(int i=0; i<additionalFloors; i++){
            addFloor(slotsPerFloor);
        }
    }

    void addFloor(Integer slotsPerFloor){
        int floorNumber = getFloorsCount() + 1;
        floors.add(new Floor(parkingLotId, floorNumber, slotsPerFloor));
    }

    public void addSlotsToFloor(Integer floorNumber, Integer additionalSlots, VehicleType vehicleType){
        Floor floor = floors.get(floorNumber - 1);
        floor.addSlots(additionalSlots, vehicleType);
    }

}
