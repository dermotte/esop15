package at.aau.esop15.course08;

import java.io.ByteArrayInputStream;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 25.11.2015 14:19.
 */
public class ByteArrayInputExample {
    private byte[] data;
    private ByteArrayInputStream bais;

    public ByteArrayInputExample(byte[] data) {
        this.data = data;
        bais = new ByteArrayInputStream(data);
    }

    /**
     * Reading the next int from the stream.
     * @return
     */
    public int nextInt() {
        return bais.read();
    }

    /**
     * Reading the next int and immediately casting it to byte.
     * @return
     */
    public byte nextByte() {
        return (byte) bais.read();
    }

    public static void main(String[] args) {
        byte[] myData = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, (byte) -1};
        ByteArrayInputExample example1 = new ByteArrayInputExample(myData);
        ByteArrayInputExample example2 = new ByteArrayInputExample(myData);
        for (int i=0; i<25; i++) {
            // behold the difference
            System.out.print(example1.nextInt() + " ");
            System.out.println(example2.nextByte());
        }
    }
}
