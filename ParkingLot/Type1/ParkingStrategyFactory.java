package lld.ParkingLot.Type1;

public class ParkingStrategyFactory {
    
    static ParkingStrategy getParkingStrategy(ParkingStrategyType parkingStrategyType){
        if(parkingStrategyType == ParkingStrategyType.NearToEntrance){
            return new ParkingStrategyNearToEntrance();
        }
        else if(parkingStrategyType == ParkingStrategyType.NearToEntrance){
            return new ParkingStrategyNearToElevator();
        }

        return new ParkingStrategyDefault();
    }
}
