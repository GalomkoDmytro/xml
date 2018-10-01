import createXml.XMLFactory;
import pars.DOM;
import pars.JDOM;
import pars.MyParser;
import utils.Resources;

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
        jdom.pars(Resources.FILE);
        jdom.checkCashAndSave(Resources.CASH_TAG, "DOM.txt");

        // pars with DOM
        MyParser dom = new DOM();
        dom.pars(Resources.FILE);
        dom.checkCashAndSave(Resources.CASH_TAG, "JDOM.txt");
    }
}
