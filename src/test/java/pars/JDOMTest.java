package pars;

import org.junit.Test;
import utils.ReadWrite;
import utils.Resources;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class JDOMTest {

    private static final String FILE = "myXmlTest.txt";
    private static final String FILE_TO_SAVE_CASH = "jdomTest.txt";

    @Test
    public void pars() {

        MyParser jdom = new JDOM();
        jdom.pars(FILE);
        jdom.checkCashAndSave(Resources.CASH_TAG, FILE_TO_SAVE_CASH);

        File file = new File(FILE_TO_SAVE_CASH);
        assertTrue(file.exists() && !file.isDirectory());

        String expected = "Person{name='Smit', address='adr2', cash=50000}" +
                "Person{name='Aron', address='adr3', cash=15500}";

        ReadWrite rw = new ReadWrite();
        String actual = rw.readFromFile(FILE_TO_SAVE_CASH);

        assertEquals(actual.trim(), expected.trim());

        deleteCreatedFile(FILE_TO_SAVE_CASH);
    }

    private void deleteCreatedFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }
}
