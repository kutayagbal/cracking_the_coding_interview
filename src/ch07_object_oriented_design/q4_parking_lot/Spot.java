package ch07_object_oriented_design.q4_parking_lot;

public class Spot {
	private long id;
	private boolean occupied = false;
	private Vehicle vehicle;

	public boolean isOccupied() {
		return occupied;
	}

	public long getId() {
		return id;
	}

	public void parkVehicle(Vehicle v) {
		this.occupied = true;
		setVehicle(v);
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void unParkVehicle() {
		this.occupied = false;
		setVehicle(null);
	}

}
