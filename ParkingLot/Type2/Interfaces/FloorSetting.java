package Interfaces;
import Models.Floor;

public interface FloorSetting {
    Floor createFloor(String parkingLotId, Integer floorNumber, Integer slotsCount);
}
