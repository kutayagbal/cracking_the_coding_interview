package ch07_object_oriented_design.q4_parking_lot.solution;

public class ParkingLot {
	private Level[] levels;
	private final int NUM_LEVELS = 5;

	public ParkingLot() {

	}

	/* Park the vehicle in a spot (or multiple spots). Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle) {
		return levels[0].parkVehicle(vehicle);
	}
}
