package at.aau.esop15.course07.namegen;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 19.11.2015 15:18.
 */
public class Letter {
    char[] data;

    public char getChar() {
        return data[((int) Math.floor(data.length * Math.random()))];
    }
}
