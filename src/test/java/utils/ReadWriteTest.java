package utils;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReadWriteTest {
    private static final String fileName = "testFile.txt";
    private static final String text = "test text";

    @Test
    public void writeToFile() {
        ReadWrite rw = new ReadWrite();

        rw.writeToFile(fileName, text, false);
        File f = new File(fileName);

        assertTrue(f.exists() && !f.isDirectory());

        deleteFile(fileName);
    }

    @Test
    public void readFromFile() {
        ReadWrite rw = new ReadWrite();
        rw.writeToFile(fileName, text, false);

        String resultText = rw.readFromFile(fileName);

        assertEquals(text, resultText);

        deleteFile(fileName);
    }

    private void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }
}
