package at.aau.esop15.course10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class KeyboardFrame extends JFrame {
    JLabel label = new JLabel();

    public KeyboardFrame() throws HeadlessException {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        label.setFont(label.getFont().deriveFont(128f));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent keyEvent) {
                if (!keyEvent.isActionKey())
                    label.setText(Character.toString(
                            keyEvent.getKeyChar()));
            }
        });
    }

    public static void main(String[] args) {
        KeyboardFrame kf = new KeyboardFrame();
        kf.setVisible(true);
    }
}

