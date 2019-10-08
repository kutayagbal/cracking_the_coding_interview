package ch07_object_oriented_design.q4_parking_lot.solution;

public class Bus extends Vehicle {
	public Bus() {
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	/* Check if the spot is large. Doesn't check num of spots */
	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.isAvailable() && spot.canFitVehicle(this);
	}
}
