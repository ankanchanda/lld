package lld.ParkingLot.Type1;

public class ParkingStrategyNearToEntrance implements ParkingStrategy {

	@Override
	public ParkingSpot findParkingSpot() {
        System.out.println("Near to entrance parking spot found");
		return null;
	}
    
}
