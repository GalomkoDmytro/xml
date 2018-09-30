package createXml;

import org.junit.Test;
import utils.Resources;

import java.io.File;

import static org.junit.Assert.*;

public class XMLFactoryTest {

    /**
     * check if download and create xml file
     * @throws Exception
     */
    @Test
    public void createXMLFile() throws Exception{
        XMLFactory xmlFactory = new XMLFactory();
        File file = new File(Resources.FILE);

        xmlFactory.createXML();
        xmlFactory.saveXML();

        assertTrue(file.exists() && !file.isDirectory());

        file.delete();
    }

}