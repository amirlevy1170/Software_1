package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends MyAbstractShip{
	public static int NUMBER_OF_SHIPS;
	private List<Weapon>Weapon;
	private int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians) {
		super(name, commissionYear, maximalSpeed, 10, crewMembers, 0);
		int totalPower = 0;
		int totalMain = 0;
		for (int i = 0; i < weapons.size(); i++) {
			Weapon weapon = weapons.get(i);
			totalPower += weapon.getFirePower();
			totalMain += weapon.getAnnualMaintenanceCost();
		}
		this.firePower += totalPower;
		this.numberOfTechnicians = numberOfTechnicians;
		totalMain =(int) totalMain*numberOfTechnicians/10;
		this.annualMaintenanceCost = 5000 + totalMain;
		NUMBER_OF_SHIPS ++;
	}

	@Override
	public List<Weapon> getWeapon() {
		return Weapon;
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}

	@Override
	public String toString() {
		String str = super.toString();
		str +="\tNumberOfTechnicians="+this.getNumberOfTechnicians()+"\n";
		return str;
	}
}
