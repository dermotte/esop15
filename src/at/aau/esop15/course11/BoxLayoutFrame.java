package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:40.
 */
public class BoxLayoutFrame extends JFrame {
    public BoxLayoutFrame() {
        super("BoxLayout Demo");
        setSize(320, 240);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new Button("Button 01"));
        panel.add(new Button("Button 02"));
        panel.add(new Button("Button 03"));
        panel.add(new Button("Button 04"));

        setContentPane(panel);
    }

    public static void main(String[] args) {
        BoxLayoutFrame f = new BoxLayoutFrame();
        f.setVisible(true);
    }
}
