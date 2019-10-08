package ch07_object_oriented_design.q4_parking_lot.solution;

import java.util.ArrayList;

public abstract class Vehicle {
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
	protected String licencePlate;
	protected int spotsNeeded;
	protected VehicleSize size;

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public VehicleSize getSize() {
		return size;
	}

	/* Park vehicle in this spot (among others, potentially) */
	public void parkInSpot(ParkingSpot spot) {
		parkingSpots.add(spot);
	}

	/* REmove car from spot and notify spot that it's gone */
	public void clearSpots() {
		for(ParkingSpot s : parkingSpots) {
			s.removeVehicle();
		}
		parkingSpots = new ArrayList<>();
	}

	/*
	 * Check if the spot is big enough for the vehicle (and is available). This
	 * compares the SIZE only It does not check if it has enough spots
	 */
	public abstract boolean canFitInSpot(ParkingSpot spot);

}
