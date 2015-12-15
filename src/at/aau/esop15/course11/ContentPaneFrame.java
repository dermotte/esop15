package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:40.
 */
public class ContentPaneFrame extends JFrame {
    public ContentPaneFrame() {
        super("BorderLayout Demo");
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.add(new Button("South"), BorderLayout.SOUTH);
        contentPane.add(new Button("North"), BorderLayout.NORTH);
        contentPane.add(new Button("Center"), BorderLayout.CENTER);
        contentPane.add(new Button("East"), BorderLayout.EAST);
        contentPane.add(new Button("West"), BorderLayout.WEST);
    }

    public static void main(String[] args) {
        ContentPaneFrame f = new ContentPaneFrame();
        f.setVisible(true);
    }
}
