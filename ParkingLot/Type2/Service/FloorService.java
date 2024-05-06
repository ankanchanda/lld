package Service;
import java.util.ArrayList;
import java.util.List;

import Enums.SlotStatus;
import Enums.VehicleType;
import Interfaces.FloorSetting;
import Models.Floor;
import Models.Slot;

public class FloorService {

    private SlotService slotService;
    FloorService(){
        slotService = new SlotService();
    }

    public List<Floor> createFloors(Integer floorsCount, String parkingLotId, Integer startingFloorNumber, Integer slotsPerFloor, FloorSetting floorSetting){

        List<Floor> floors = new ArrayList<>();

        for(int i=0; i<floorsCount; i++){
            Floor floor = addFloor(parkingLotId, startingFloorNumber + i, slotsPerFloor, floorSetting);
            floors.add(floor);
        }
        return floors;
    }

    public Floor addFloor(String parkingLotId, Integer floorNumber, Integer slotsCount, FloorSetting floorSetting){
        return floorSetting.createFloor(parkingLotId, floorNumber, slotsCount);
    }

    public void addSlotsToFloor(Floor floor, Integer floorNumber, Integer additionalSlots, VehicleType vehicleType){
        List<Slot> slots = floor.getSlots();
        Integer slotsCount = slots.size();
        List<Slot> newSlots = slotService.addSlots(additionalSlots, slotsCount + 1, floor.getParkingLotId(), floorNumber, vehicleType, SlotStatus.AVAILABLE);
        slots.addAll(newSlots);
    }

    public boolean isSlotAvailableForVehcicleType(Floor floor, VehicleType vehicleType){
        Integer availableSlotsCount =  getAvailableSlotsCountByVehicleType(floor, vehicleType);
        return availableSlotsCount > 0;
    }

    public Integer getAvailableSlotsCountByVehicleType(Floor floor, VehicleType vehicleType){
        
        List<Slot> availableSlots = getSlotsAvailableByVehcicleType(floor, vehicleType);
        return availableSlots.size();
    }

    public List<Slot> getSlotsAvailableByVehcicleType(Floor floor, VehicleType vehicleType){
        List<Slot> slots = floor.getSlots();
        List<Slot> availableSlots = new ArrayList<>();

        for(Slot slot: slots){
            if(slotService.isSlotAvailableForVehicleType(slot, vehicleType)){
                availableSlots.add(slot);
            }
        }

        return availableSlots;
    }

    public List<Slot> getOccupiedSlotsByVehicleType(Floor floor, VehicleType vehicleType){
        List<Slot> slots = floor.getSlots();
        List<Slot> occupiedSlots = new ArrayList<>();

        for(Slot slot: slots){
            if(slotService.isSlotOccupiedForVehicleType(slot, vehicleType)){
                occupiedSlots.add(slot);
            }
        }

        return occupiedSlots;
    }
    
}
