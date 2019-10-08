package ch07_object_oriented_design.q4_parking_lot.solution;

/* Represents a level in a parking garage */
public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0; // number of free spots
	private final int SPOTS_PER_ROW = 10;

	public Level(int flr, int numberSpots) {
	}

	public int availableSpots() {
		return availableSpots;
	}

	/* Find a place to park this vehicle. Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle) {
		return spots[0].park(vehicle);
	}

	/*
	 * Park a vehicle starting at the spot spotNumber, and continuing until
	 * vehicle.spotsNeeded.
	 */
	private boolean parkStartingAtSpot(int num, Vehicle v) {
		for (int i = num; i < num + v.spotsNeeded; i++) {
			spots[i].park(v);
		}
		return true;
	}

	/* Find a spot to park this vehicle. Return index of spot, or -1 on failure. */
	private int findAvailableSpots(Vehicle vehicle) {
		return -1;
	}

	/* When a car was removed from the spot, increment availableSpots */
	public void spotFreed() {
		availableSpots++;
	}
}
