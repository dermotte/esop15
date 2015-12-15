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
public class SimpleSwingApplication extends JFrame {
    public SimpleSwingApplication() {
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

        // adding Event Handlers:
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action fired.");
            }
        });

        generateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouse entered button!");
            }
        });

    }

    public static void main(String[] args) {
        SimpleSwingApplication f = new SimpleSwingApplication();
        f.setVisible(true);
    }
}
