package entities;

import java.util.Objects;

public class Person {

    protected String name;
    protected String address;
    protected int cash;

    public Person(){}

    public Person(String name, String address, int cash) {
        this.name = name;
        this.address = address;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person shortPerson = (Person) o;
        return cash == shortPerson.cash &&
                Objects.equals(name, shortPerson.name) &&
                Objects.equals(address, shortPerson.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, cash);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cash=" + cash +
                '}';
    }
}
