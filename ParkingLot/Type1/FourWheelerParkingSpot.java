package lld.ParkingLot.Type1;

public class FourWheelerParkingSpot extends ParkingSpot{

	FourWheelerParkingSpot(int id, float price) {
		super(id, price);
	}

	@Override
	int getPrice() {
		return 20;
	}
    
}
