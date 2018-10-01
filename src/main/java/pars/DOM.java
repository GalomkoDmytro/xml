package pars;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import entities.Person;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import utils.Resources;

/**
 * Parsing XML file with DOM.
 */
public class DOM extends MyParser {

    public DOM() {
    }

    /**
     * Parsing XML file with DOM.
     * File to parsing set in Resources.class
     */
    public void pars(String fileName) {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(Resources.PERSON);

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Person person = new Person();
                    Element eElement = (Element) nNode;
                    person.setName(eElement
                            .getElementsByTagName(Resources.NAME)
                            .item(0)
                            .getTextContent());
                    person.setAddress(eElement
                            .getElementsByTagName(Resources.ADDRESS)
                            .item(0)
                            .getTextContent());
                    person.setCash(Integer.valueOf(eElement
                            .getElementsByTagName(Resources.CASH)
                            .item(0)
                            .getTextContent()));

                    personList.add(person);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
