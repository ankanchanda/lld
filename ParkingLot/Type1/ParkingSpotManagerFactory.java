package lld.ParkingLot.Type1;

import java.util.List;

public class ParkingSpotManagerFactory{

    List<ParkingSpot> parkingSpots;

    ParkingSpotManagerFactory(List<ParkingSpot> parkingSpots){
        this.parkingSpots = parkingSpots;
    }
    
    ParkingSpotManager getParkingSpotManager(VehicleType type){
        if(type == VehicleType.TwoWheeler){
            return new TwoWheelerParkingSpotManager(this.parkingSpots);
        }
        else if(type == VehicleType.FourWheeler){
            return new FourWheelerParkingSpotManager(parkingSpots);
        }

        throw new TypeNotPresentException("Vehicle Type " + type.toString() + "is not supported yet.", null);
    }
}
