package entities;

import java.util.Objects;

public class FullPerson extends Person {

    private int id;

    private String education;

    public FullPerson(){};

    public FullPerson(int id, String name, String address, int cash, String education) {
        super(name, address, cash);
        this.id = id;
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullPerson person = (FullPerson) o;
        return id == person.id &&
                cash == person.cash &&
                Objects.equals(name, person.name) &&
                Objects.equals(address, person.address) &&
                Objects.equals(education, person.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, cash, education);
    }

    @Override
    public String toString() {
        return "FullPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cash=" + cash +
                ", education='" + education + '\'' +
                '}';
    }

}
