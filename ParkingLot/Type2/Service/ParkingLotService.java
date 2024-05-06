package Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Enums.VehicleType;
import Implementations.DefaultFloorSetting;
import Models.Floor;
import Models.ParkingLot;
import Models.Slot;

public class ParkingLotService {

    private FloorService floorService;
    public ParkingLotService(){
        floorService = new FloorService();
    }

    public ParkingLot createParkingLot(String parkingLotId, Integer numberOfFloors, Integer slotsPerFloor){
        List<Floor> floors = floorService.createFloors(numberOfFloors, parkingLotId, 1, slotsPerFloor, new DefaultFloorSetting());

        ParkingLot parkingLot =  new ParkingLot(parkingLotId, floors);
        System.out.println("Created parking lot with " + numberOfFloors + " floors and " + slotsPerFloor + " slots per floor");
        return parkingLot;
    }
    
    public Map<Integer, Integer> getFreeSlotsCountByVehicleType(ParkingLot parkingLot, VehicleType vehicleType){
        List<Floor> floors = parkingLot.getFloors();

        Map<Integer, Integer> freeSlotsCount = new TreeMap<>();
        for(Floor floor: floors){
            Integer availableSlots = floorService.getAvailableSlotsCountByVehicleType(floor, vehicleType);
            if(availableSlots > 0){
                freeSlotsCount.put(floor.getFloorNumber(), availableSlots);
            }
        }

        return freeSlotsCount;
    }

    public List<Slot> getFreeSlotsInFloorByVehicleType(Floor floor, VehicleType vehicleType){
        List<Slot> freeSlots = floorService.getSlotsAvailableByVehcicleType(floor, vehicleType);
        return freeSlots;
    }

    public Map<Integer, List<Slot>> getFreeSlotsByVehicleType(ParkingLot parkingLot, VehicleType vehicleType){
        List<Floor> floors = parkingLot.getFloors();
        Map<Integer, List<Slot>> availableSlots = new TreeMap<>();

        for(Floor floor: floors){
            List<Slot> slots = getFreeSlotsInFloorByVehicleType(floor, vehicleType);
            availableSlots.put(floor.getFloorNumber(), slots);
        }

        return availableSlots;
    }

    public Map<Integer, List<Slot>> getOccupiedSlots(ParkingLot parkingLot, VehicleType vehicleType){

        List<Floor> floors = parkingLot.getFloors();

        Map<Integer, List<Slot>> occupiedSlots = new TreeMap<>();
        for(Floor floor: floors){
            List<Slot> slots = floorService.getOccupiedSlotsByVehicleType(floor, vehicleType);
            occupiedSlots.put(floor.getFloorNumber(), slots);
        }
        return occupiedSlots;
    }
}
