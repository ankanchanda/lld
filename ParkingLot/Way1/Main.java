package lld.ParkingLot.Way1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();

        for(int i=0; i<100; i++){
            if(i<60){
                parkingSpots.add(new TwoWheelerParkingSpot(i, 10));
            }
            else{
                parkingSpots.add(new TwoWheelerParkingSpot(i, 20));
            }
        }

        ParkingSpotManagerFactory factory = new ParkingSpotManagerFactory(parkingSpots);
        EntranceGate entranceGate = new EntranceGate(factory);
        ExitGate exitGate = new ExitGate(factory);

        Vehicle vehicle = new Vehicle(123, VehicleType.TwoWheeler);
        ParkingSpot spot = entranceGate.findParkingSpace(vehicle.getVehicleType(), parkingSpots, ParkingStrategyType.NearToEntrance);
        Ticket ticket = entranceGate.generateTicket(vehicle, spot);
        exitGate.removeVehicle(ticket);
    }
}
