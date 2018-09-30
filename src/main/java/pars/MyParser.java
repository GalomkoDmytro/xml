package pars;

import entities.Person;
import utils.ReadWrite;
import utils.Resources;

import java.util.ArrayList;
import java.util.List;

public abstract class MyParser {

    protected List<Person> personList = new ArrayList<>();
    protected ReadWrite fWriter = new ReadWrite();

    public abstract void pars();

    /**
     * Check if person earned more than some value
     *
     * @param person
     */
    protected boolean isLookingCashAmount(Person person) {
        if (person.getCash() >= Resources.CASH_TAG) {
            System.out.println("pars with " + this.getClass() + ": " + person);
            return true;
        }
        return false;
    }

    /**
     * @param obj shod contained override method toString()
     */
    protected abstract void saveToFile(Object obj);

}
