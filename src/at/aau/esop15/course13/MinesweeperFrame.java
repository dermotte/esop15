package at.aau.esop15.course13;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.01.2016 14:12.
 */
public class MinesweeperFrame extends JFrame {
    public MinesweeperFrame() {
        super("Minesweeper");
        try {
            setIconImage(ImageIO.read(new File("data/minesweeper/32/Bomb.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MinesweeperFrame f = new MinesweeperFrame();
        f.setSize(600, 600);
        f.add(new MinesweeperPanel(), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}
