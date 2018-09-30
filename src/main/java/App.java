import createXml.XMLFactory;
import pars.DOM;
import pars.JDOM;
import pars.MyParser;

/**
 * @author Dmytro_Galomko
 */
public class App {

    public static void main(String[] args) {
        new App();
    }

    public App() {
        // create xml file
        XMLFactory xmlFactory = new XMLFactory();
        try {
            xmlFactory.createXML();
            xmlFactory.saveXML();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // pars with JDOM
        MyParser jdom = new JDOM();
        jdom.pars();

        // pars with DOM
        MyParser dom = new DOM();
        dom.pars();
    }
}
