package at.aau.esop15.course07.namegen;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 19.11.2015 15:18.
 */
public class Pattern {
    Letter[] pattern;

    public Pattern(Letter[] pattern) {
        this.pattern = pattern;
    }

    public CharSequence getName() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pattern.length; i++) {
            Letter letter = pattern[i];
            result.append(letter.getChar());
        }
        return result;
    }
}
