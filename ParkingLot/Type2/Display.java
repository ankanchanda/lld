import java.util.List;
import java.util.Map;

public class Display {
 
    private ParkingLot parkingLot;
    Display(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public void displayFreeSlotsCount(VehicleType vehicleType){
        Map<Integer, Integer> freeSlotsCount = parkingLot.getFreeSlotsCountByVehicleType(vehicleType);
        for(Map.Entry<Integer, Integer> freeSlotsCountElement: freeSlotsCount.entrySet()){
            Integer floorNumber = freeSlotsCountElement.getKey();
            Integer availableSlotsCount = freeSlotsCountElement.getValue();

            System.out.println("No. of free slots for " + vehicleType.toString() + " on Floor " + floorNumber.toString() + " : " +  availableSlotsCount);
        }
    }

    public void displayFreeSlots(VehicleType vehicleType){
        Map<Integer, List<Slot>> freeSlots = parkingLot.getFreeSlotsByVehicleType(vehicleType);
        for(Map.Entry<Integer, List<Slot>> freeSlotsElement: freeSlots.entrySet()){
            Integer floorNumber = freeSlotsElement.getKey();
            List<Slot> slots = freeSlotsElement.getValue();

            System.out.print("Free slots for " + vehicleType.toString() + " on Floor " + floorNumber.toString() + " : ");
            for(int i=0; i<slots.size(); i++){
                Integer slotId = slots.get(i).getSlotId();
                if( i == slots.size() - 1){
                    System.out.println(slotId.toString());
                }
                else{
                    System.out.print(slotId.toString() + ", ");
                }
            }
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
            default:
                System.out.println("Invalid Display Type");
                break;
        }

    }
}
