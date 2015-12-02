package at.aau.esop15.lesson09;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 02.12.2015.
 */
public class FirstNameListBuilder {
    File namesFile;
    ArrayList names = null;

    public FirstNameListBuilder(File f) {
        this.namesFile = f;
        names = new ArrayList(1500);
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
                    names.add(line.split(",")[0]);
                }
            } while (line != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getNames() {
        return (String[]) names.toArray(new String[names.size()]);
    }

    public static void main(String[] args) {
        FirstNameListBuilder f = new FirstNameListBuilder(new File("data\\yob2000.txt"));
        f.read();
        String[] names = f.getNames();
        System.out.println(names[(int) Math.floor(Math.random()*names.length)]);
    }
}
