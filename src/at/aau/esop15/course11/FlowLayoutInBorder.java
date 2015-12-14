package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:47.
 */
public class FlowLayoutInBorder extends JFrame {
    public FlowLayoutInBorder() {
        super("BorderLayout Demo");
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new Button("OK"));
        panel.add(new Button("Cancel"));
        add(panel, BorderLayout.SOUTH);
        add(new TextArea(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame f = new FlowLayoutInBorder();
        f.setVisible(true);
    }
}
