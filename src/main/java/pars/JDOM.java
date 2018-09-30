package pars;

import java.io.File;
import java.io.IOException;
import java.util.List;

import entities.Person;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import utils.Resources;

/**
 * Parsing XML file with JDOM
 */
public class JDOM extends MyParser {

    public JDOM() {
    }

    /**
     * Parsing XML file with JDOM
     * File to parsing set in Resources.class
     */
    public void pars() {
        try {
            File inputFile = new File(Resources.FILE);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element rootElement = document.getRootElement();
            Element notebook = rootElement.getChild(Resources.NOTEBOOK);

            List<Element> personElementList = notebook.getChildren(Resources.PERSON);
            for (int i = 0; i < personElementList.size(); i++) {
                Person person = new Person();

                Element elPerson = personElementList.get(i);
                fillPerson(person, elPerson);

                if(isLookingCashAmount(person)) {
                    saveToFile(person);
                }

                // add to Collection
                personList.add(person);
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void fillPerson(Person shortPerson, Element elPerson) {
        shortPerson.setName(elPerson.getChild(Resources.NAME).getText());
        shortPerson.setAddress(elPerson.getChild(Resources.ADDRESS).getText());
        shortPerson.setCash(Integer.valueOf(elPerson.getChild(Resources.CASH).getText()));
    }

    protected void saveToFile(Object person) {
        fWriter.writeToFile("JDOM.txt", person.toString(), true);
    }

}
