package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.12.2015 16:08.
 */
public class ActionListenerApplication extends JFrame {
    public ActionListenerApplication() {
        super("My Name Generator - ESOP 15/16");
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // components
        JLabel titleLabel = new JLabel("Name Generator");
        titleLabel.setFont(titleLabel.getFont().deriveFont(22f));
        JLabel patternLabel = new JLabel("Pattern:");
        JTextField patterField = new JTextField("t Vccv");
        JButton generateButton = new JButton("Generate");
        JTextArea outputArea = new JTextArea();

        // organizing button, labels and text field:
        JPanel inputPanel = new JPanel(new BorderLayout(5,5));
        inputPanel.add(titleLabel, BorderLayout.NORTH);
        inputPanel.add(patternLabel, BorderLayout.WEST);
        inputPanel.add(patterField, BorderLayout.CENTER);
        inputPanel.add(generateButton, BorderLayout.EAST);

        // content panel
        JPanel contentPane = new JPanel(new BorderLayout(5,5));
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(outputArea, BorderLayout.CENTER);
        setContentPane(contentPane);

        // creating the objects
        JMenuBar mb = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuFileItemExit = new JMenuItem("Exit");
        JMenu menuHelp = new JMenu("Help");
        JMenuItem menuHelpItemAbout = new JMenuItem("About");
        // putting it all together
        mb.add(menuFile);
        menuFile.add(menuFileItemExit);
        mb.add(menuHelp);
        menuHelp.add(menuHelpItemAbout);
        // adding it to the frame:
        setJMenuBar(mb);

        // listener:
        ActionListener listener = new CustomActionListener();
        generateButton.addActionListener(listener);
        menuFileItemExit.addActionListener(listener);
        menuHelpItemAbout.addActionListener(listener);

    }

    public static void main(String[] args) {
        ActionListenerApplication f = new ActionListenerApplication();
        f.setVisible(true);
    }
}

class CustomActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Generate":
                // todo: write to output ...
                break;
            case "About":
                JOptionPane.showMessageDialog(null, "Developed for ESOP 2015/2016");
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
                System.err.println("Could not recognize command " + cmd);
                break;
        }
    }
}
