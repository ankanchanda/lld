package lld.ParkingLot.Way1;

public class Ticket {
    long entryTime;
    ParkingSpot parkingSpot;
    Vehicle vehicle;

    Ticket(long entryTime, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }
}
