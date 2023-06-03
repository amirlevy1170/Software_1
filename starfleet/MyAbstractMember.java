package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class MyAbstractMember implements CrewMember {
    protected String name;
    protected int yearsInService;
    protected int age;

    public MyAbstractMember(int age, int yearsInService, String name){
        this.age=age;
        this.yearsInService = yearsInService;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getYearsInService() {
        return this.yearsInService;
    }

    @Override
    public int gatAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyAbstractMember that = (MyAbstractMember) o;
        return yearsInService == that.yearsInService && age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearsInService, age);
    }

}
