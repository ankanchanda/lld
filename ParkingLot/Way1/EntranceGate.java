package lld.ParkingLot.Way1;

import java.util.List;

public class EntranceGate {
    ParkingSpotManagerFactory factory;

    EntranceGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    ParkingSpot findParkingSpace(VehicleType vehicleType, List<ParkingSpot> spots, ParkingStrategyType parkingStrategyType) {
        ParkingSpotManager manager = factory.getParkingSpotManager(vehicleType);
        return manager.findParkingSpot(parkingStrategyType);
    }

    Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new Ticket(0, parkingSpot, vehicle);
    }
}
