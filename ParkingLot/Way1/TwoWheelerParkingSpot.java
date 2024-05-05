package lld.ParkingLot.Way1;

public class TwoWheelerParkingSpot extends ParkingSpot{

	TwoWheelerParkingSpot(int id, float price) {
		super(id, price);
	}

	@Override
	int getPrice() {
		return 10;
	}

}
