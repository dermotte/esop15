package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:40.
 */
public class ContainerHierarchyFrame extends JFrame {
    public ContainerHierarchyFrame() {
        super("ContainerHierarchy Demo");
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        JPanel panel = new JPanel(new BorderLayout());
        contentPane.add(new Button("South"), BorderLayout.SOUTH);
        contentPane.add(new Button("North"), BorderLayout.NORTH);
        contentPane.add(new Button("East"), BorderLayout.EAST);
        contentPane.add(new Button("West"), BorderLayout.WEST);
        contentPane.add(panel, BorderLayout.CENTER);
        // inner ...
        panel.add(new Button("Inner South"), BorderLayout.SOUTH);
        panel.add(new Button("Inner North"), BorderLayout.NORTH);
        panel.add(new Button("Inner East"), BorderLayout.EAST);
        panel.add(new Button("Inner West"), BorderLayout.WEST);
        panel.add(new Button("Inner Center"), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        ContainerHierarchyFrame f = new ContainerHierarchyFrame();
        f.setVisible(true);
    }
}
