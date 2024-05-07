package Implementations;
import java.util.ArrayList;
import java.util.List;

import Enums.SlotStatus;
import Enums.VehicleType;
import Interfaces.FloorSetting;
import Models.Floor;
import Models.Slot;
import Service.SlotService;

public class DefaultFloorSetting implements FloorSetting{

    SlotService slotService;
    public DefaultFloorSetting(SlotService slotService){
       this.slotService = slotService;
    }

    @Override
    public Floor createFloor(String parkingLotId, Integer floorNumber, Integer slotsCount) {
        List<Slot> slots = new ArrayList<>();
        Slot truckSlot = slotService.addSlot(1, parkingLotId, floorNumber, VehicleType.TRUCK, SlotStatus.AVAILABLE);
        List<Slot> bikeSlots = slotService.addSlots(Math.min(slotsCount - 1, 2), 2, parkingLotId, floorNumber, VehicleType.BIKE, SlotStatus.AVAILABLE);
        List<Slot> carSlots = slotService.addSlots(Math.max(0, slotsCount - 3), Math.min(slotsCount - 1, 2) + 2, parkingLotId, floorNumber, VehicleType.CAR, SlotStatus.AVAILABLE);
        
        slots.add(truckSlot);
        slots.addAll(bikeSlots);
        slots.addAll(carSlots);

        return new Floor(parkingLotId, floorNumber, slots);
    }
    
}
