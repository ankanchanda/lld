package lld.ParkingLot.Type1;

public class ParkingStrategyNearToElevator implements ParkingStrategy{

	@Override
	public ParkingSpot findParkingSpot() {
        System.out.println("Near to elevator parking spot found");
		return null;
	}
    
}
