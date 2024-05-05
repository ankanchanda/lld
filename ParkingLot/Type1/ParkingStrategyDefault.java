package lld.ParkingLot.Type1;

public class ParkingStrategyDefault implements ParkingStrategy{

	@Override
	public ParkingSpot findParkingSpot() {
        System.out.println("Default parking spot found");
		return null;
	}
    
}
