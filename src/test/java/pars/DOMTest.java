package pars;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class DOMTest {

    private static final String FILE = "myXml.txt";

    /**
     * check if parser get three object from  Xml file
     *
     * @throws Exception
     */
    @Test
    public void pars() throws Exception {
        MyParser myParser = new DOM();

        // get aces to List<Person>
        Field fieldList = getField();

        myParser.pars();

        // check size
        assertEquals(3, myParser.personList.size());

        deleteCreatedFile();
    }

    private Field getField() throws NoSuchFieldException {
        Class<?> clazz = MyParser.class;
        Field field = clazz.getDeclaredField("personList");
        field.setAccessible(true);
        return field;
    }

    private void deleteCreatedFile() {
        File file = new File(FILE);
        file.delete();
    }
}