package utils;

import java.io.*;

public class ReadWrite {

    public ReadWrite() {
    }

    /**
     * Create or join to file new string data
     *
     * @param fileName , might contain file location
     * @param text     data to save
     * @param append   to file or create new file
     */
    public void writeToFile(String fileName, String text, boolean append) {
        BufferedWriter bw = null;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, append);
            bw = new BufferedWriter(fileWriter);
            bw.write(text);
            bw.write("\n");
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (bw != null) try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Get text from file
     *
     * @param fileName , might contain file location
     * @return String with content
     */
    public String readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            File file = new File(fileName);
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);

            String st;
            while ((st = br.readLine()) != null) {
                stringBuilder.append(st);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return stringBuilder.toString();
    }

}
