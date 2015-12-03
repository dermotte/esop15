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
            String[] tempNames = new String[120000];
            int count = 0;
            do {
                line = br.readLine();
                // comments;
                if (line != null && !line.startsWith("#") && line.trim().length() > 1) {
                    String name = line.split(",")[0];
                    // System.out.println(name);
                    tempNames[count] = name;
                    count++;
                }
            } while (line != null);
            // copy the actual names to an array of the right size ..
            names = new String[count];
            /*
            // copy the slow way ..
            for (int i = 0; i < names.length; i++) {
                names[i] = tempNames[i];
            }
            */
            System.arraycopy(tempNames, 0, names, 0, count);
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
        String[] names = f.getNames();
        System.out.println(names[(int) (Math.random()*names.length)]);
    }
}
