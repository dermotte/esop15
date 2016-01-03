package at.aau.esop15.course11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 17.12.2015 15:11.
 */
public class IdeaFunTwo {
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;
    private JPanel myPanel;

    public IdeaFunTwo(JFrame f) {
        f.setContentPane(myPanel);
        f.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        IdeaFunTwo t = new IdeaFunTwo(f);
        f.setSize(640, 480);
        f.setVisible(true);
    }
}
