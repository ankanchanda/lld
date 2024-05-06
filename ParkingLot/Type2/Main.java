import java.util.Scanner;

import Constants.Constants;
import Enums.VehicleType;
import Models.ParkingLot;
import Service.DisplayService;
import Service.ParkingLotService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLotService parkingLotService = new ParkingLotService();
        DisplayService displayService = null;

        while(true){
            String input = scanner.nextLine();
            if(input.equals(Constants.EXIT)){
                break;
            }

            String[] inputSplit = input.split(" ");
            String operation = inputSplit[0];
            switch (operation) {
                case Constants.CREATE_PARKING_LOT:
                    ParkingLot parkingLot = parkingLotService.createParkingLot(inputSplit[1], Integer.parseInt(inputSplit[2]), Integer.parseInt(inputSplit[3]));
                    displayService = new DisplayService(parkingLot);
                    break;
                case Constants.DISPLAY:
                    displayService.display(inputSplit[1], VehicleType.valueOf(inputSplit[2]));
                    break;
            }
        }

        scanner.close();
    }   
}
