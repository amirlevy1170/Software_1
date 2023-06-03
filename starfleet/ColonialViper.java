package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter  {
	public static int NUMBER_OF_SHIPS;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		int totalMain = 0;
		for (int i = 0; i < weapons.size(); i++) {
			Weapon weapon = weapons.get(i);
			totalMain += weapon.getAnnualMaintenanceCost();
		}
		totalMain = (int) (totalMain+Math.floor(Double.parseDouble(String.valueOf(500*maximalSpeed))));
		this.annualMaintenanceCost = 4000 + crewMembers.size()*500+totalMain;
		NUMBER_OF_SHIPS ++;
	}

}
