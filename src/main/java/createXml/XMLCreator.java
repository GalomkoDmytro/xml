package createXml;


import entities.FullPerson;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.Resources;

/**
 * Create XML file
 */
public class XMLCreator {

    private Document doc;

    public XMLCreator() {
    }

    public void createXML() throws Exception {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.newDocument();

        // root elem
        Element rootElement = doc.createElement(Resources.CATALOG);
        doc.appendChild(rootElement);

        // notebook elem
        Element notebook = doc.createElement(Resources.NOTEBOOK);
        rootElement.appendChild(notebook);

        // persons
        notebook.appendChild(addPerson(new FullPerson(1, "John", "adr1", 500, "edu")));
        notebook.appendChild(addPerson(new FullPerson(2, "Smit", "adr2", 50000, "edu2")));
        notebook.appendChild(addPerson(new FullPerson(3, "Aron", "adr3", 15500, "edu3")));

    }

    private Element addPerson(FullPerson person) {
        Element elPerson = doc.createElement(Resources.PERSON);

        // set id
        Attr attrId = doc.createAttribute(Resources.ID);
        attrId.setValue(String.valueOf(person.getId()));
        elPerson.setAttributeNode(attrId);

        // name
        Element name = doc.createElement(Resources.NAME);
        name.appendChild(doc.createTextNode(person.getName()));
        elPerson.appendChild(name);

        // address
        Element addr = doc.createElement(Resources.ADDRESS);
        addr.appendChild(doc.createTextNode(person.getAddress()));
        elPerson.appendChild(addr);

        // cash
        Element cash = doc.createElement(Resources.CASH);
        cash.appendChild(doc.createTextNode(String.valueOf(person.getCash())));
        elPerson.appendChild(cash);

        // education
        Element edu = doc.createElement(Resources.EDUCATION);
        edu.appendChild(doc.createTextNode(person.getEducation()));
        elPerson.appendChild(edu);

        return elPerson;
    }

    public void saveXML() throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(Resources.FILE));
        transformer.transform(source, result);
    }

}



