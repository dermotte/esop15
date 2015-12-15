package at.aau.esop15.course11;

import javax.swing.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:08.
 */
public class SimpleFrameWithMenu extends JFrame {
    public SimpleFrameWithMenu() {
        super("My Simple Example");
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // creating the objects
        JMenuBar mb = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuFileItemOpen = new JMenuItem("Open ...");
        JMenuItem menuFileItemExit = new JMenuItem("Exit");
        // putting it all together
        mb.add(menuFile);
        menuFile.add(menuFileItemOpen);
        menuFile.addSeparator();
        menuFile.add(menuFileItemExit);
        // adding it to the frame:
        setJMenuBar(mb);
    }

    public static void main(String[] args) {
        SimpleFrameWithMenu f = new SimpleFrameWithMenu();
        f.setVisible(true);
    }
}
