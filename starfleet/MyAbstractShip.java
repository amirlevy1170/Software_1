package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class MyAbstractShip implements Spaceship {
    protected String name;
    protected int commissionYear;
    protected float maximalSpeed;
    protected int firePower;
    protected Set<? extends CrewMember> crewMembers;
    protected int annualMaintenanceCost;

    public MyAbstractShip(String name, int commissionYear, float maximalSpeed,
                          int firePower, Set<? extends CrewMember> crewMembers, int annualMaintenanceCost) {
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.firePower = firePower;
        this.crewMembers = crewMembers;
        this.annualMaintenanceCost = annualMaintenanceCost;
    }

    protected MyAbstractShip() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCommissionYear() {
        return commissionYear;
    }

    @Override
    public float getMaximalSpeed() {
        return maximalSpeed;
    }

    @Override
    public int getFirePower() {
        return firePower;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return crewMembers;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        return annualMaintenanceCost;
    }

    @Override
    public String toString() {
        String str = "";
        str += this.getClass().getSimpleName()+"\n";
        str +="\tName="+this.getName()+"\n";
        str +="\tCommissionYear="+getCommissionYear()+"\n";
        str +="\tMaximalSpeed="+getMaximalSpeed()+"\n";
        str +="\tFirePower="+getFirePower()+"\n";
        str +="\tCrewMembers="+getCrewMembers().size()+"\n";
        str +="\tAnnualMaintenanceCost="+getAnnualMaintenanceCost()+"\n";
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyAbstractShip that = (MyAbstractShip) o;
        return commissionYear == that.commissionYear && Float.compare(that.maximalSpeed, maximalSpeed) == 0 && firePower == that.firePower && annualMaintenanceCost == that.annualMaintenanceCost && name.equals(that.name) && Objects.equals(crewMembers, that.crewMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, commissionYear, maximalSpeed, firePower, crewMembers, annualMaintenanceCost);
    }
}
