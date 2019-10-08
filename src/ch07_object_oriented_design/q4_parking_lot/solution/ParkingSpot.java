package ch07_object_oriented_design.q4_parking_lot.solution;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	/* Check if the spot is big enough and is available */
	public boolean canFitVehicle(Vehicle vehicle) {
		return vehicle.size == spotSize;
	}

	/* Park vehicle in this spot. */
	public boolean park(Vehicle v) {
		this.vehicle = v;
		return true;
	}

	public int getRow() {
		return row;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	/* Remove vehicle from spot, and notify level that a new spot is available */
	public void removeVehicle() {
		level.spotFreed();
	}
}
