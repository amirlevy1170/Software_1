package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends MyAbstractShip {
	protected List<Weapon>Weapon;
	public static int NUMBER_OF_SHIPS;

	public Fighter(String name, int commissionYear, float maximalSpeed,
				   Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name,commissionYear,maximalSpeed,10, crewMembers,0);
		int totalPower = 0;
		int totalMain = 0;
		for (int i = 0; i < weapons.size(); i++) {
			Weapon weapon = weapons.get(i);
			totalPower += weapon.getFirePower();
			totalMain += weapon.getAnnualMaintenanceCost();
		}
		totalMain = (int) (2500+totalMain+Math.ceil((double) 1000*maximalSpeed));
		this.annualMaintenanceCost = totalMain;
		this.firePower += totalPower;
		this.Weapon=weapons;
		NUMBER_OF_SHIPS++;
	}

	@Override
	public List<Weapon> getWeapon() {
		return Weapon;
	}

	@Override
	public String toString() {
		String str= super.toString();
		str +="\tWeapon="+this.getWeapon().toString();
		return str;
	}
}
