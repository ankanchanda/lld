package Models;

import java.util.List;


public class ParkingLot {

    private String parkingLotId;
    private List<Floor> floors; 

    public ParkingLot(String parkingLotId, List<Floor> floors) {
        this.parkingLotId = parkingLotId;
        this.floors = floors;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Integer getFloorsCount() {
        return floors.size();
    }
}
