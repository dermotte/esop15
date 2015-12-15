package at.aau.esop15.course07;

/**
 * @author Dr. Mathias Lux, 16.11.2015.
 */
public class NameGenerator {
    private static char[] consonants = "bcdfghjklmnpqrstvwxz".toCharArray();
    private static char[] vowels = "aeiouy".toCharArray();
    private static String[] titles = "Lord King Diva Queen Baron Duke Doc Incredible Tiny Unworthy Extreme Holy Stinking Dirty Smelly Tall Improbable Awesome Invisible Impossible Malicious Bold Uncommon".split(" ");

    public static void main(String[] args) {
        // feel free to experiment with patterns.
        System.out.println(getRandomName("t Cvc Cvcc"));
        System.out.println(getRandomName("Cvcvvc Cvcc, known as .the t"));
        System.out.println(getRandomName("Vccv Cvvcvcc"));
        System.out.println(getRandomName("Cc'Vc Ccvcv"));
        System.out.println(getRandomName("t C'Cv Vccvcv"));
        System.out.println(getRandomName("Vcvcv Vcvvcvcvv"));
        System.out.println(getRandomName("Vvccvc"));
        System.out.println(getRandomName("Cvccvc"));
    }

    public static String getRandomName(String pattern) {
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
