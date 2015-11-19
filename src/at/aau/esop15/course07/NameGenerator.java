package at.aau.esop15.course07;

/**
 * @author Dr. Mathias Lux, 16.11.2015.
 */
public class NameGenerator {
    private static char[] consonants = "bcdfghjklmnpqrstvwxz".toCharArray();
    private static char[] vowels = "aeiouy".toCharArray();
    private static String[] titles = "Lord King Diva Queen Doc Incredible Tiny Unworthy Extreme Holy Stinking Dirty Smelly".split(" ");

    public static void main(String[] args) {
        System.out.println(getRandomName("t Cvc Cvcc"));
        System.out.println(getRandomName("Cvcvvc Cvcc, known as .the t"));
    }

    private static String getRandomName(String pattern) {
        char[] c = pattern.toCharArray();
        StringBuilder sb = new StringBuilder(pattern.length());
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'v') {
                sb.append(getRandomChar(vowels));
            } else if (c[i] == 'c') {
                sb.append(getRandomChar(consonants));
            } else if (c[i] == 'V') {
                sb.append(Character.toUpperCase(getRandomChar(vowels)));
            } else if (c[i] == 'C') {
                sb.append(Character.toUpperCase(getRandomChar(consonants)));
            } else if (c[i] == 't' || c[i] == 'T') {
                sb.append(titles[(int) Math.floor(Math.random()*titles.length)]);
            } else if (c[i] == '.') {
                sb.append(c[++i]);
            } else {
                sb.append(c[i]);
            }

        }
        return sb.toString();
    }

    private static char getRandomChar(char[] chars) {
        double index = 0;
        index = Math.random() * chars.length;
        return chars[(int) Math.floor(index)];
    }
}
