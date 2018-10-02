package createXml;

import org.junit.Test;
import utils.Resources;

import java.io.File;

import static org.junit.Assert.*;

public class XMLCreatorTest {

    /**
     * check if download and create xml file
     * @throws Exception
     */
    @Test
    public void createXMLFile() throws Exception{
        XMLCreator xmlCreator = new XMLCreator();
        File file = new File(Resources.FILE);

        xmlCreator.createXML();
        xmlCreator.saveXML();

        assertTrue(file.exists() && !file.isDirectory());

        file.delete();
    }

}