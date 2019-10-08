package ch07_object_oriented_design.q4_parking_lot;

import java.util.ArrayList;

public class ParkingLot {
	private static final int totalSpotCount = 100;
	private ArrayList<Spot> allSpots;
	private int occupiedSpotCount = 0;

	public ParkingLot() {
		allSpots = new ArrayList<>(totalSpotCount);
	}

	public int availableSpotCount() {
		return totalSpotCount - occupiedSpotCount;
	}

	public Spot[] acceptVehicle(Vehicle v) {
		if (availableSpotCount() < v.getType().getOccupiedSpotCount()) {
			return null;
		}

		for (int i = 0; i < allSpots.size(); i++) {
			Spot spot = allSpots.get(i);
			if (!spot.isOccupied()) {
				if (v.getType() == VehicleType.CAR) {
					spot.parkVehicle(v);
					occupiedSpotCount += 1;
					return new Spot[] { spot };
				} else if (v.getType() == VehicleType.MINIBUS && i + 1 <= totalSpotCount) {
					Spot nextSpot = allSpots.get(i + 1);
					if (!nextSpot.isOccupied()) {
						spot.parkVehicle(v);
						nextSpot.parkVehicle(v);
						occupiedSpotCount += 2;
						return new Spot[] { spot, nextSpot };
					}
				} else if (v.getType() == VehicleType.BUS && i + 2 <= totalSpotCount) {
					Spot nextSpot = allSpots.get(i + 1);
					Spot nextOfNextSpot = allSpots.get(i + 2);
					if (!nextSpot.isOccupied() && !nextOfNextSpot.isOccupied()) {
						spot.parkVehicle(v);
						nextSpot.parkVehicle(v);
						nextOfNextSpot.parkVehicle(v);

						occupiedSpotCount += 3;
						return new Spot[] { spot, nextSpot, nextOfNextSpot };
					}
				}
			}
		}

		return null;
	}

	public void deliverVehicle(Vehicle v) {
		for (int i = 0; i < allSpots.size(); i++) {
			Spot s = allSpots.get(i);
			if (s.isOccupied() && s.getVehicle().getPlate().equals(v.getPlate())) {
				if (v.getType() == VehicleType.CAR) {
					s.unParkVehicle();
				} else if (v.getType() == VehicleType.MINIBUS) {
					s.unParkVehicle();
					allSpots.get(i + 1).unParkVehicle();
				} else if (v.getType() == VehicleType.BUS) {
					s.unParkVehicle();
					allSpots.get(i + 1).unParkVehicle();
					allSpots.get(i + 2).unParkVehicle();
				}
				occupiedSpotCount--;
			}
		}
	}

	public void deliverVehicle(Spot[] spots) {
		for (Spot s : spots) {
			s.unParkVehicle();
			occupiedSpotCount--;
		}
	}
}
