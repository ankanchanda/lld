package Service;

import java.util.ArrayList;
import java.util.List;

import Enums.SlotStatus;
import Enums.VehicleType;
import Models.Slot;
import Models.Vehicle;

public class SlotService {

    public Slot addSlot(Integer id, String parkingLotId, Integer floorNumber, VehicleType vehicleType, SlotStatus slotStatus){
        return new Slot(id, parkingLotId, floorNumber, vehicleType, slotStatus);
    }

    public List<Slot> addSlots(Integer slotsToAdd, Integer startingId, String parkingLotId, Integer floorNumber, VehicleType vehicleType, SlotStatus slotStatus){
        List<Slot> slots = new ArrayList<>();
        for(int i=0; i<slotsToAdd; i++){
            Slot slot = addSlot(startingId + i, parkingLotId, floorNumber, vehicleType, slotStatus);
            slots.add(slot);
        }

        return slots;
    }

    public void bookSlot(Slot slot, Vehicle vehicle){
        slot.setSlotStatus(SlotStatus.OCCUPIED);
    }

    public void releaseSlot(Slot slot){
        slot.setSlotStatus(SlotStatus.AVAILABLE);
    }

    public Boolean isSlotAvailableForVehicleType(Slot slot, VehicleType vehicleType){
        VehicleType slotVehicleType = slot.getAsscociatedVehicleType();
        SlotStatus slotStatus = slot.getSlotStatus();

        return vehicleType == slotVehicleType &&  slotStatus == SlotStatus.AVAILABLE;
    }

    public Boolean isSlotOccupiedForVehicleType(Slot slot, VehicleType vehicleType){
        VehicleType slotVehicleType = slot.getAsscociatedVehicleType();
        SlotStatus slotStatus = slot.getSlotStatus();

        return vehicleType == slotVehicleType &&  slotStatus == SlotStatus.OCCUPIED;
    }
}
