package pars;

import entities.Person;
import utils.ReadWrite;
import utils.Resources;

import java.util.ArrayList;
import java.util.List;

public abstract class MyParser {

    protected List<Person> personList = new ArrayList<>();
    protected ReadWrite fWriter = new ReadWrite();

    public abstract void pars(String fileName);

    /**
     * @param obj should contained override method toString()
     */
    protected void saveToFile(Person obj, String fileName) {
        fWriter.writeToFile(fileName, obj.toString(), true);
    }

    /**
     * Check if person earned more than some (@param cashAmount) and save to file (@param saveTo)
     * @param cashAmount
     * @param saveTo
     */
    public void checkCashAndSave(int cashAmount, String saveTo) {
        if(personList.isEmpty()) {
            System.out.println("Nothing to save");
            return;
        }

        for (Person person : personList) {
            if(isLookingCashAmount(person, cashAmount)) {
                saveToFile(person, saveTo);
            }
        }
    }

    /**
     * Check if person earned more than some value
     *
     * @param person
     * @param cashAmount
     */
    protected boolean isLookingCashAmount(Person person, int cashAmount) {
        if (person.getCash() >= cashAmount) {
            System.out.println("pars with " + this.getClass() + ": " + person);
            return true;
        }
        return false;
    }



}
