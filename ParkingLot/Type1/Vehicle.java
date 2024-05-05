package lld.ParkingLot.Type1;

public class Vehicle {

    private int vehicleNumber;
    private VehicleType vehicleType;

    Vehicle(int vehicleNumber, VehicleType vehicleType){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}
}
