package at.aau.esop15.course13;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileCacheImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.01.2016 14:15.
 */
public class MinesweeperPanel extends JPanel {
    int row = 15, col = 15;
    char[][] mineField = new char[row][col];
    char[][] userView = new char[row][col];

    HashMap<Character, BufferedImage> assets;

    boolean gameOver = false;

    Font myFont;

    public MinesweeperPanel() {
        // init view
        for (int i = 0; i < userView.length; i++) {
            char[] chars = userView[i];
            for (int j = 0; j < chars.length; j++) {
                chars[j] = 'h';
            }
        }
        // legen wir minen ...
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[i].length; j++) {
                if (Math.random() < 0.1)
                    mineField[i][j] = 'b';
                else
                    mineField[i][j] = ' ';
            }
        }
        // nachbarschaft
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[i].length; j++) {
                if (mineField[i][j] == ' ') {
                    int mineCount = 0;
                    for (int ii = -1; ii <= 1; ii++) {
                        for (int jj = -1; jj <= 1; jj++) {
                            if (i + ii >= 0 && i + ii < row && j + jj >= 0 && j + jj < col) {
                                if (mineField[i + ii][j + jj] == 'b') mineCount++;
                            }
                        }
                    }
                    mineField[i][j] = ("" + mineCount).toCharArray()[0];
                }
            }
        }
        // pre load assets
        assets = new HashMap<>(12);
        try {
            assets.put('b', ImageIO.read(new File("data/minesweeper/32/Bomb.png")));
            assets.put('0', ImageIO.read(new File("data/minesweeper/32/Base-Grey.png")));
            assets.put('1', ImageIO.read(new File("data/minesweeper/32/1.png")));
            assets.put('2', ImageIO.read(new File("data/minesweeper/32/2.png")));
            assets.put('3', ImageIO.read(new File("data/minesweeper/32/3.png")));
            assets.put('4', ImageIO.read(new File("data/minesweeper/32/4.png")));
            assets.put('5', ImageIO.read(new File("data/minesweeper/32/5.png")));
            assets.put('6', ImageIO.read(new File("data/minesweeper/32/6.png")));
            assets.put('7', ImageIO.read(new File("data/minesweeper/32/7.png")));
            assets.put('8', ImageIO.read(new File("data/minesweeper/32/8.png")));
            assets.put('h', ImageIO.read(new File("data/minesweeper/32/Beveled.png")));
            assets.put('f', ImageIO.read(new File("data/minesweeper/32/Flag.png")));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = e.getY() / 32;
                int c = e.getX() / 32;
                System.out.printf("button %d, x %d, y %d, col/row = %d/%d\n",
                        e.getButton(), e.getX(), e.getY(), c, r);
                interact(c, r, e.getButton());
            }
        });
        myFont = new Font("Roboto", Font.BOLD, 64);
        setPreferredSize(new Dimension(col * 32, row * 32));
    }

    private void interact(int c, int r, int button) {
        if (c < col && r < row && !gameOver) {
            if (button == 1) {
                if (userView[r][c] == 'h') {
                    if (mineField[r][c] == 'b') {
                        gameOver = true;
                    }
                    userView[r][c] = 'v';
                    // discover ...
                    if (mineField[r][c] == '0') {
                        discover(r, c);
                    }
                }
            } else if (button == 3) {
                if (userView[r][c] == 'h') {
                    userView[r][c] = 'f';
                } else if (userView[r][c] == 'f') {
                    userView[r][c] = 'h';
                }
            } else if (button == 2) {
                // count flags ...
                int flags = 0;
                for (int ii = -1; ii <= 1; ii++) {
                    for (int jj = -1; jj <= 1; jj++) {
                        if (r + ii >= 0 && r + ii < row && c + jj >= 0 && c + jj < col) {
                            if (mineField[r + ii][c + jj] == 'b') flags++;
                        }
                    }
                }
                if (mineField[r][c] == Integer.toString(flags).charAt(0)) {
                    for (int ii = -1; ii <= 1; ii++) {
                        for (int jj = -1; jj <= 1; jj++) {
                            if (r + ii >= 0 && r + ii < row && c + jj >= 0 && c + jj < col) {
                                if (userView[r + ii][c + jj] == 'h') interact(c + jj, r + ii, 1);
                            }
                        }
                    }
                }
            }
        }
        repaint();
    }

    private void discover(int r, int c) {
        for (int ii = -1; ii <= 1; ii++) {
            for (int jj = -1; jj <= 1; jj++) {
                if (r + ii >= 0 && r + ii < row && c + jj >= 0 && c + jj < col) {
                    interact(c + jj, r + ii, 1);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(myFont);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (userView[r][c] == 'h') { // versteckt
                    g2.drawImage(assets.get('h'), c * 32, r * 32, null);
                } else if (userView[r][c] == 'f') { // flagged
                    g2.drawImage(assets.get('f'), c * 32, r * 32, null);
                } else { // entdeckt
                    g2.drawImage(assets.get(mineField[r][c]), c * 32, r * 32, null);
                }
            }
        }
        if (gameOver) g2.drawString("Game Over!", 100, 100);
    }
}
