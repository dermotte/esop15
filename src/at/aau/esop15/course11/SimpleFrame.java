package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:08.
 */
public class SimpleFrame extends JFrame {
    public SimpleFrame() {
        super("My Simple Example");
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleFrame f = new SimpleFrame();
        f.setVisible(true);
    }
}
