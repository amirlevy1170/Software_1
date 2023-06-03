package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {
	public static int NUMBER_OF_SHIPS;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		NUMBER_OF_SHIPS ++;
		this.annualMaintenanceCost += StealthCruiser.NUMBER_OF_SHIPS * 50;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name,commissionYear,maximalSpeed,crewMembers,StealthCruiser.weaponMaker());


	}

	public static List<Weapon> weaponMaker(){
		List<Weapon>weaponList = new ArrayList<>();
		Weapon weapon = new Weapon("Laser Cannon",10,100);
		weaponList.add(weapon);
		return weaponList;
	}

}
