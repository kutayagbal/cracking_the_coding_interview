package ch07_object_oriented_design.q4_parking_lot;

public enum VehicleType {
	CAR(1), MINIBUS(2), BUS(3);
	private int occupiedSpotCount;

	private VehicleType(int c) {
		occupiedSpotCount = c;
	}

	public int getOccupiedSpotCount() {
		return occupiedSpotCount;
	}

}
