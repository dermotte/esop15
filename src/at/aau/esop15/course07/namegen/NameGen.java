package at.aau.esop15.course07.namegen;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 19.11.2015 15:10.
 */
public class NameGen {
    public static void main(String[] args) {
        Letter[] pattern = {
                new Consonant(),
                new Vowel(),
                new Consonant(),
                new Consonant(),
                new Vowel()};
        Pattern p = new Pattern(pattern);

        for (int i=0;i<10;i++) {
            System.out.println(p.getName());
        }
    }
}
