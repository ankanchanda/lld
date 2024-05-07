import java.util.Scanner;

import Constants.Constants;
import Enums.VehicleType;
import Models.ParkingLot;
import Models.Ticket;
import Models.Vehicle;
import Service.DisplayService;
import Service.ParkingLotService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot =  null;
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
                case Constants.CREATE_PARKING_LOT: {
                        parkingLot = parkingLotService.createParkingLot(inputSplit[1], Integer.parseInt(inputSplit[2]), Integer.parseInt(inputSplit[3]));
                        displayService = new DisplayService(parkingLot);
                    }
                    break;
                case Constants.DISPLAY:
                    displayService.display(inputSplit[1], VehicleType.valueOf(inputSplit[2]));
                    break;
                case Constants.PARK_VEHICLE: {
                        Vehicle vehicle = new Vehicle(inputSplit[2], inputSplit[3], VehicleType.valueOf(inputSplit[1]));
                        Ticket ticket = parkingLotService.parkVehicle(parkingLot, vehicle);
                        if(ticket == null){
                            System.out.println("Parking Lot Full");
                        }
                        else{
                            System.out.println("Parked Vehicle. Ticket ID: " + ticket.getId());
                        }
                    }
                    break;
                case Constants.UNPARK_VEHICLE: {
                        Vehicle vehicle = parkingLotService.unparkVehicle(inputSplit[1]);
                        if(vehicle == null){
                            System.out.println("Invalid Ticket");
                        }
                        else{
                            System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegistrationNumber() + "and Color: " + vehicle.getColor());
                        }
                    }
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }

        scanner.close();
    }   
}
