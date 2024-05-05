import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    
    private String parkingLotId;
    List<Floor> floors; 

    public ParkingLot(String parkingLotId, Integer floorsCount, Integer slotsPerFloor) {
        this.parkingLotId = parkingLotId;
        floors = new ArrayList<>();
        for(int i=0; i<floorsCount; i++){
            floors.add(new Floor(i, slotsPerFloor));
        }
    }

    void addFloor(Integer slotsAllocatedToFloor){
        int floorNumber = floors.size();
        floors.add(new Floor(floorNumber, slotsAllocatedToFloor));
    }

    void addSlotsToFloor(Integer floorNumber, Integer additionalSlots){
        Floor floor = floors.get(floorNumber);
        floor.addSlots(additionalSlots);
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

    public Integer getSlotsForFloor(Integer floorNumber){
        Floor floor = floors.get(floorNumber);
        return floor.getSlots();
    }

}
