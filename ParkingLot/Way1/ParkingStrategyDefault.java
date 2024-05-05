package lld.ParkingLot.Way1;

public class ParkingStrategyDefault implements ParkingStrategy{

	@Override
	public ParkingSpot findParkingSpot() {
        System.out.println("Default parking spot found");
		return null;
	}
    
}
