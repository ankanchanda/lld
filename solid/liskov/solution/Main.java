package lld.solid.liskov.solution;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new MotorCycle());
        vehicleList.add(new Car());
        vehicleList.add(new Bicycle());

        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.getNumberOfWheels().toString());
        }

        List<EngineVehicle> engineVehicleList = new ArrayList<>();
        engineVehicleList.add(new MotorCycle());
        engineVehicleList.add(new Car());
        // engineVehicleList.add(new Bicycle()); // gives compile time error

        for(EngineVehicle vehicle: engineVehicleList){
            System.out.println(vehicle.hasEngine().toString());
        }
    }
}
