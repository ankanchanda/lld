package lld.solid.liskov;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new MotorCycle()); // works
        vehicleList.add(new Car()); // works

        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.hasEngine().toString());
        }

        // works all good till above

        vehicleList.add(new Bicycle()); 
        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.hasEngine().toString()); 
            // for cycle hasEngine -> null throws null pointer exception
        }
    }
}
