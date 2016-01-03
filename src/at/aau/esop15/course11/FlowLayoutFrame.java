package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:40.
 */
public class FlowLayoutFrame extends JFrame {
    public FlowLayoutFrame() {
        super("FlowLayout Demo");
        setSize(320, 240);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        JPanel panel = new JPanel(flowLayout);
        panel.add(new JButton("Button 01"));
        panel.add(new JButton("Button 02"));
        panel.add(new JButton("Button 03"));
        panel.add(new JButton("Button 04"));

        setContentPane(panel);
    }

    public static void main(String[] args) {
        FlowLayoutFrame f = new FlowLayoutFrame();
        f.setVisible(true);
    }
}
