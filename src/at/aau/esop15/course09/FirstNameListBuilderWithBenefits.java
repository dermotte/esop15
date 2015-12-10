package at.aau.esop15.course09;

import java.io.*;
import java.util.HashMap;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 02.12.2015.
 */
public class FirstNameListBuilderWithBenefits {
    File namesFile;
    HashMap<String, Stats> names = null;

    public FirstNameListBuilderWithBenefits(File f) {
        this.namesFile = f;
        names = new HashMap<>(1500);
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
                    String[] tmp = line.split(",");
                    names.put(tmp[0], new Stats(tmp[1], Integer.parseInt(tmp[2])));
                }
            } while (line != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getNames() {
        return (String[]) names.keySet().toArray(new String[names.size()]);
    }

    public static void main(String[] args) {
        FirstNameListBuilderWithBenefits f = new FirstNameListBuilderWithBenefits(new File("data\\yob2000.txt"));
        f.read();
        String[] names = f.getNames();
        System.out.println(names[(int) Math.floor(Math.random()*names.length)]);
    }

    class Stats {
        String mf;
        int count;

        public Stats(String mf, int count) {
            this.mf = mf;
            this.count = count;
        }
    }
}
