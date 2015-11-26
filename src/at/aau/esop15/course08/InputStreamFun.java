package at.aau.esop15.course08;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 25.11.2015 14:34.
 */
public class InputStreamFun {
    public static void main(String[] args) {
        // init data
        byte[] data = new byte[128];
        for (int i = 0; i < data.length; i++) {
            data[i] = ((byte) (i % 255));
        }
        // create stream
        ByteArrayInputStream bis = new ByteArrayInputStream(data);

        // read single int:
        System.out.println(bis.read());

        // read with buffer:
        byte[] buf = new byte[16];
        int read;
        try {
            read = bis.read(buf);
            System.out.println("bytes read = " + read);
            System.out.println(Arrays.toString(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read to part of the buffer:
        do {
            read = bis.read(buf, 1, 13);
            System.out.println("bytes read = " + read);
        } while (read > 0);

    }
}
