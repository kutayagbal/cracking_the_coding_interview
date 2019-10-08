package ch07_object_oriented_design.q4_parking_lot;

public class Vehicle {
	private String plate;
	private VehicleType type;
	private Spot[] spots;

	public Vehicle(String plate, VehicleType type) {
		this.plate = plate;
		this.type = type;
	}

	public Spot[] getSpots() {
		return spots;
	}

	public void setSpots(Spot[] spots) {
		this.spots = spots;
	}

	public String getPlate() {
		return plate;
	}

	public VehicleType getType() {
		return type;
	}
	
	
}
