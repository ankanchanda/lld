public class VehicleTypeManager {
    
    public static VehicleType getVehicleType(String vehicleType){

        switch (vehicleType) {
            case "CAR":
                return VehicleType.CAR;
            case "BIKE":
                return VehicleType.BIKE;
            case "TRUCK":
                return VehicleType.TRUCK;
            default:
                return null;
        }
    }
}
