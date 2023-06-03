package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends MyAbstractShip {

	public static int NUMBER_OF_SHIPS;
	private int cargoCapacity;
	private int passengerCapacity;

	public TransportShip(String name, int commissionYear, float maximalSpeed,
						 Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity) {
		super(name, commissionYear, maximalSpeed, 10, crewMembers,
				3000 + 5 * cargoCapacity + 3 * passengerCapacity);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
		NUMBER_OF_SHIPS++;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	@Override
	public String toString() {
		String str = super.toString();
		str += "\tCargoCapacity=" + getCargoCapacity() + "\n";
		str += "\tPassengerCapacity=" + getPassengerCapacity() + "\n";
		return str;
	}
}
