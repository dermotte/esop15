package at.aau.esop15.minesweeper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * This is an extended version of the Minesweeper from the lecture with restart and the ability to put it into a jar file.
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.01.2016 14:12.
 */
public class GameFrame extends JFrame {
    public GameFrame() {
        super("Minesweeper");
        try {
            setIconImage(ImageIO.read(GameFrame.class.getResource("images/Bomb.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GameFrame f = new GameFrame();
        f.setSize(600, 600);
        GamePanel gamePanel;
        if (args.length > 1) {
            int rows = 20, cols = 20;
            try {
                rows = Integer.parseInt(args[0]);
                cols = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            gamePanel = new GamePanel(rows, cols);
        } else
            gamePanel = new GamePanel(20, 20);
        f.add(gamePanel, BorderLayout.CENTER);
        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gamePanel.newGame();
                    f.repaint();
                }
            }
        });
        f.pack();
        f.setVisible(true);
    }
}
