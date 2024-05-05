package lld.ParkingLot.Way1;

public class ParkingStrategyFactory {
    
    static ParkingStrategy getParkingStrategy(ParkingStrategyType parkingStrategyType){
        if(parkingStrategyType == ParkingStrategyType.NearToEntrance){
            return new ParkingStrategyNearToEntrance();
        }
        else if(parkingStrategyType == ParkingStrategyType.NearToEntrance){
            return new ParkingStrategyNearToElevator();
        }

        throw new TypeNotPresentException("Parking Strategy " + parkingStrategyType.toString() + " is not supported yet", null);
    }
}
