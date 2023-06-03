package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear(Collection<Spaceship> fleet) {
		List<Spaceship> shipDescriptionsSorted = new ArrayList<>(fleet);
		shipDescriptionsSorted.sort(Comparator.comparing(Spaceship::getFirePower)
				.thenComparing(Spaceship::getCommissionYear)
				.thenComparing(Spaceship::getName).reversed());
		List<String> shipsNames = new ArrayList<>();
		for (Spaceship spaceship : shipDescriptionsSorted) {
			shipsNames.add(spaceship.toString());
		}
		return shipsNames;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> instanceNumberPerClass = new HashMap<>();
		for (Spaceship spaceship : fleet) {
			String spaceClass = spaceship.getClass().getSimpleName();
			if (instanceNumberPerClass.containsKey(spaceClass)) {
				int val = instanceNumberPerClass.get(spaceClass) + 1;
				instanceNumberPerClass.replace(spaceClass, val);
			} else {
				instanceNumberPerClass.put(spaceClass, 1);
			}
		}
		return instanceNumberPerClass;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost(Collection<Spaceship> fleet) {
		int totalMain = 0;
		for (Spaceship spaceship : fleet) {
			totalMain += spaceship.getAnnualMaintenanceCost();
		}
		return totalMain;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> fleetWeaponNames = new HashSet<>();
		for (Spaceship spaceship : fleet) {
			if (!spaceship.getClass().getSimpleName().equals("TransportShip")) {
				if (spaceship.getWeapon() != null) {
					for (Weapon weapon : spaceship.getWeapon()) {
						fleetWeaponNames.add(weapon.getName());
					}
				}
			}
		}
		return fleetWeaponNames;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int totalCrew = 0;
		for (Spaceship spaceship : fleet) {
			totalCrew += spaceship.getCrewMembers().size();
		}
		return totalCrew;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships.
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int totalOfficers = 0;
		int totalOfficersAges = 0;
		for (Spaceship spaceship : fleet) {
			for (CrewMember crewMember : spaceship.getCrewMembers()) {
				if (crewMember.getClass().getSimpleName().equals("Officer")) {
					totalOfficers++;
					totalOfficersAges += crewMember.gatAge();
				}
			}
		}
		float age =(float)totalOfficersAges / totalOfficers;
		return age;
	}


	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> highestRankingOfficerPerShip = new HashMap<>();
		for (Spaceship spaceship : fleet) {
			List<? extends CrewMember> crewMembers = new ArrayList<>(spaceship.getCrewMembers());
			boolean firstOfficer = true;
			Officer officer = new Officer(null, 5, 5, null);
			int i = 0;
			//getting the first officer if exist
			while (firstOfficer && i < crewMembers.size()) {
				CrewMember crewMember = crewMembers.get(i);
				if (crewMember.getClass().getSimpleName().equals("Officer")) {
					firstOfficer = false;
					officer = (Officer) crewMember;
				}
				i++;
			}
			//getting the highest ranking officer
			while (i < crewMembers.size()) {
				CrewMember crewMember = crewMembers.get(i);
				if (crewMember.getClass().getSimpleName().equals("Officer")) {
					Officer optOfficer = (Officer) crewMember;
					if (optOfficer.getRank().compareTo(officer.getRank()) > 0) {
						officer = optOfficer;
					}
				}
				i++;
			}
			if (officer.name != null) {
				highestRankingOfficerPerShip.put(officer, spaceship);
			}
		}
		return highestRankingOfficerPerShip;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> rankIntegerMap = new HashMap<>();
		for (Spaceship spaceship : fleet) {
			List<? extends CrewMember> crewMembers = new ArrayList<>(spaceship.getCrewMembers());
			for (CrewMember crewMember : crewMembers) {
				if (crewMember.getClass().getSimpleName().equals("Officer")) {
					OfficerRank officerRank = ((Officer) crewMember).getRank();
					if (rankIntegerMap.containsKey(officerRank)) {
						int val = rankIntegerMap.get(officerRank) + 1;
						rankIntegerMap.replace(officerRank, val);
					} else {
						rankIntegerMap.put(officerRank, 1);
					}
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>>entryList =new ArrayList<>(rankIntegerMap.entrySet());
		entryList.sort(Comparator.comparing(Map.Entry<OfficerRank,Integer>::getValue)
				.thenComparing(Map.Entry<OfficerRank,Integer>::getKey));
		return entryList;
	}
}



