package lld.ParkingLot.Type1;

public class ExitGate {
    ParkingSpotManagerFactory factory;

    ExitGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    void removeVehicle(Ticket ticket) {
        ParkingSpotManager manager = factory.getParkingSpotManager(ticket.vehicle.getVehicleType());
        manager.removeVehicle(ticket.vehicle);
    }
}
