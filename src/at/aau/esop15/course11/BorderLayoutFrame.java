package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:40.
 */
public class BorderLayoutFrame extends JFrame {
    public BorderLayoutFrame() {
        super("BorderLayout Demo");
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(5, 5));
        add(new Button("South"), BorderLayout.SOUTH);
        add(new Button("North"), BorderLayout.NORTH);
        add(new Button("Center"), BorderLayout.CENTER);
        add(new Button("East"), BorderLayout.EAST);
        add(new Button("West"), BorderLayout.WEST);
    }

    public static void main(String[] args) {
        BorderLayoutFrame f = new BorderLayoutFrame();
        f.setVisible(true);
    }
}
