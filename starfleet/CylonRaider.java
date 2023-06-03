package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {
	public static int NUMBER_OF_SHIPS;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		int totalMain = 0;
		for (int i = 0; i < weapons.size(); i++) {
			Weapon weapon = weapons.get(i);
			totalMain += weapon.getAnnualMaintenanceCost();
		}
		totalMain = (int) (totalMain+Math.floor(Double.parseDouble(String.valueOf(1200*maximalSpeed))));
		this.annualMaintenanceCost = 3500 +500*crewMembers.size() + totalMain;
		NUMBER_OF_SHIPS++;
	}


	

}
