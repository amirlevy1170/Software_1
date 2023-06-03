package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public class Officer extends CrewWoman {
	protected OfficerRank rank;

	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age,yearsInService,name);
		this.rank = rank;
	}

	public OfficerRank getRank() {
		return rank;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Officer officer = (Officer) o;
		return rank == officer.rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), rank);
	}
}
