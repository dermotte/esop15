package at.aau.esop15.course08;

import java.io.*;

/**
 * Created by mlux on 26.11.2015.
 */
public class FirstNameArrayBuilder {
    File namesFile;
    String[] names = null;

    public FirstNameArrayBuilder(File f) {
        this.namesFile = f;
    }

    public void read() {
        try {
            FileReader fr = new FileReader(namesFile);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            do {
                line = br.readLine();
                // comments;
                if (line !=null && !line.startsWith("#") && line.trim().length()>1) {
                    System.out.println(line.split(",")[0]);
                    // ToDo: put it into array and use it in the name generator
                }
            } while (line != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getNames() {
        return names;
    }

    public static void main(String[] args) {
        FirstNameArrayBuilder f = new FirstNameArrayBuilder(new File("data\\yob2000.txt"));
        f.read();
    }
}
