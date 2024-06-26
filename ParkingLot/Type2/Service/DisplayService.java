package Service;
import java.util.List;
import java.util.Map;

import Constants.Constants;
import Enums.VehicleType;
import Models.ParkingLot;
import Models.Slot;

public class DisplayService {

    private ParkingLotService parkingLotService;
    ParkingLot parkingLot;

    public DisplayService(ParkingLot parkingLot){
        parkingLotService = new ParkingLotService();
        this.parkingLot = parkingLot;
    }
    public void displayFreeSlotsCount(VehicleType vehicleType){
        Map<Integer, Integer> freeSlotsCount = parkingLotService.getFreeSlotsCountByVehicleType(parkingLot, vehicleType);
        for(Map.Entry<Integer, Integer> freeSlotsCountElement: freeSlotsCount.entrySet()){
            Integer floorNumber = freeSlotsCountElement.getKey();
            Integer availableSlotsCount = freeSlotsCountElement.getValue();

            System.out.println("No. of free slots for " + vehicleType.toString() + " on Floor " + floorNumber.toString() + " : " +  availableSlotsCount);
        }
    }

    public void displayFreeSlots(VehicleType vehicleType){
        Map<Integer, List<Slot>> freeSlots = parkingLotService.getFreeSlotsByVehicleType(parkingLot, vehicleType);
        for(Map.Entry<Integer, List<Slot>> freeSlotsElement: freeSlots.entrySet()){
            Integer floorNumber = freeSlotsElement.getKey();
            List<Slot> slots = freeSlotsElement.getValue();

            System.out.print("Free slots for " + vehicleType.toString() + " on Floor " + floorNumber.toString() + " : ");
            for(int i=0; i<slots.size(); i++){
                Integer slotId = slots.get(i).getId();
                if( i == slots.size() - 1){
                    System.out.print(slotId.toString());
                }
                else{
                    System.out.print(slotId.toString() + ", ");
                }
            }
            System.out.println();
        }
    }

    void displayOccupiedSlots(VehicleType vehicleType){

        Map<Integer, List<Slot>> occupiedSlots = parkingLotService.getOccupiedSlots(parkingLot, vehicleType);
        for(Map.Entry<Integer, List<Slot>> occupiedSlotsElement: occupiedSlots.entrySet()){
            Integer floorNumber = occupiedSlotsElement.getKey();
            List<Slot> slots = occupiedSlotsElement.getValue();

            System.out.print("Occupied slots for " + vehicleType.toString() + " on Floor " + floorNumber.toString() + " : ");
            for(int i=0; i<slots.size(); i++){
                Integer slotId = slots.get(i).getId();
                if( i == slots.size() - 1){
                    System.out.print(slotId.toString());
                }
                else{
                    System.out.print(slotId.toString() + ", ");
                }
            }
            System.out.println();
        }

    }

    public void display(String displayType, VehicleType vehicleType){
        switch (displayType) {
            case Constants.DISPLAY_FREE_COUNT:
                displayFreeSlotsCount(vehicleType);
                break;
            case Constants.DISPLAY_FREE_SLOTS:
                displayFreeSlots(vehicleType);
                break;
            case Constants.DISPLAY_OCCUPIED_SLOTS:
                displayOccupiedSlots(vehicleType);
                break;
            default:
                System.out.println("Invalid Display Type");
                break;
        }
    }
}
