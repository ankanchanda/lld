import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot;
        Display display = null;

        while(true){
            String input = scanner.nextLine();
            if(input.equals(Constants.EXIT)){
                break;
            }

            String[] inputSplit = input.split(" ");
            String operation = inputSplit[0];
            if(operation.equals(Constants.CREATE_PARKING_LOT)){
                String parkingLotId = inputSplit[1];
                Integer numberOfFloors = Integer.parseInt(inputSplit[2]);
                Integer numberOfSlotsPerFLoor = Integer.parseInt(inputSplit[3]);

                parkingLot = new ParkingLot(parkingLotId, numberOfFloors, numberOfSlotsPerFLoor);
                display = new Display(parkingLot);

                System.out.println("Created parking lot with " + numberOfFloors.toString() + " floors and " + numberOfSlotsPerFLoor.toString() + " slots per floor");
            }
            else if(operation.equals(Constants.DISPLAY)){
                display.display(inputSplit[1], VehicleTypeManager.getVehicleType(inputSplit[2]));
            }
        }

        scanner.close();
    }   
}
