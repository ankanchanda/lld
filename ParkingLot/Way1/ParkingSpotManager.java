package lld.ParkingLot.Way1;

import java.util.List;

public abstract class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;

    ParkingSpotManager(List<ParkingSpot> parkingSpots){
        this.parkingSpots = parkingSpots;
    }

    abstract ParkingSpot findParkingSpot();

    void parkVehicle(Vehicle v){
        ParkingSpot spot = findParkingSpot();
        spot.parkVehicle(v);
    }

    void removeVehicle(Vehicle v){
        for(ParkingSpot spot: this.parkingSpots){
            if(spot != null && spot.vehicle.equals(v)){
                spot.removeVehicle();
                break;
            }
        }
    }

    void addParkingSpace(ParkingSpot spot){
        this.parkingSpots.add(spot);
    }

    void removeParkingSpace(ParkingSpot spot){
        int index = this.parkingSpots.indexOf(spot);
        this.parkingSpots.remove(index);
    }
}
