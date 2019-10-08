package ch07_object_oriented_design.q4_parking_lot.solution;

public class Car extends Vehicle {
	public Car() {
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	/* Check if the spot compact or large. */
	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.isAvailable() && spot.canFitVehicle(this);
	}
}