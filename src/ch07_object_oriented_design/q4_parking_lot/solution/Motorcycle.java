package ch07_object_oriented_design.q4_parking_lot.solution;

public class Motorcycle extends Vehicle {
	public Motorcycle() {
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.isAvailable() && spot.canFitVehicle(this);
	}
}