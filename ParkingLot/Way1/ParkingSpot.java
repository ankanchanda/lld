package lld.ParkingLot.Way1;

abstract class ParkingSpot {
    int id;
    boolean isEmpty;
    Vehicle vehicle;
    float price;

    ParkingSpot(int id, float price){
        this.id = id;
        this.price = price;
    }

    void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        isEmpty = false;
    }

    void removeVehicle(){
        vehicle = null;
        isEmpty = true;
    }

    abstract int getPrice();
}