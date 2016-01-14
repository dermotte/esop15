package at.aau.esop15.course13;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by mlux on 08.01.2016.
 */
public class GamePanel extends JPanel {
    // sprites for easy access:
    HashMap<Character, BufferedImage> sprites = new HashMap<>(12);
    // actual layout:
    int rows = 15;
    int cols = 15;
    int numberOfMines = 0;
    char[][] minefield = new char[cols][rows]; // where are the mines
    char[][] visible   = new char[cols][rows]; // what is already visible to the user?
    private boolean gameOver = false;
    private int offsetY;
    private int offsetX;
    private boolean won = false;
    private final Font gameFont;

    public GamePanel() {
        super();
        // load Sprites:
        try {
            sprites.put('0', ImageIO.read(new FileInputStream("data/minesweeper/32/Base-Grey.png")));
            sprites.put('1', ImageIO.read(new FileInputStream("data/minesweeper/32/1.png")));
            sprites.put('2', ImageIO.read(new FileInputStream("data/minesweeper/32/2.png")));
            sprites.put('3', ImageIO.read(new FileInputStream("data/minesweeper/32/3.png")));
            sprites.put('4', ImageIO.read(new FileInputStream("data/minesweeper/32/4.png")));
            sprites.put('5', ImageIO.read(new FileInputStream("data/minesweeper/32/5.png")));
            sprites.put('6', ImageIO.read(new FileInputStream("data/minesweeper/32/6.png")));
            sprites.put('7', ImageIO.read(new FileInputStream("data/minesweeper/32/7.png")));
            sprites.put('8', ImageIO.read(new FileInputStream("data/minesweeper/32/8.png")));
            sprites.put('b', ImageIO.read(new FileInputStream("data/minesweeper/32/Bomb.png")));
            sprites.put('f', ImageIO.read(new FileInputStream("data/minesweeper/32/Flag.png")));
            sprites.put('h', ImageIO.read(new FileInputStream("data/minesweeper/32/Beveled.png"))); // hidden
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int col = (int) Math.floor((e.getX() - offsetX) / 32);
                int row = (int) Math.floor((e.getY() - offsetY) / 32);

                uncover(row, col, e.getButton() == MouseEvent.BUTTON3);
            }
        });

        // init visibility:
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                visible[col][row] = 'h';
            }
        }

        // init mine field:
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                minefield[col][row] = '0';
                if (Math.random() < 0.1) {
                    minefield[col][row] = 'b';
                    numberOfMines++;
                }
            }
        }
        // set the number of neighbour mines.
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (minefield[col][row] == '0') { // it's not a mine.
                    int count = 0;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int c = col + x;
                            int r = row + y;
                            if (c >= 0 && r >= 0 && c < cols && r < rows) { // check for the edges
                                if (minefield[c][r] == 'b') count++;
                            }
                        }
                    }
                    minefield[col][row] = Integer.toString(count).charAt(0);
                }
            }
        }

        // create a Font:
        gameFont = new Font("Hobo Std", Font.PLAIN, 64);

        // and this is for frame.pack().
        this.setMinimumSize(new Dimension(cols*32, rows*32));
        this.setPreferredSize(new Dimension(cols*32, rows*32));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(gameFont);
        g2.setColor(Color.RED);
        // determine offset:
        offsetY = (int) ((this.getSize().getHeight() - rows * 32) / 2);
        offsetX = (int) ((this.getSize().getWidth() - cols * 32) / 2);
        // paint game state:
        for (int col = 0; col < visible.length; col++) {
            for (int row = 0; row < visible[col].length; row++) {
                if (!gameOver) {
                    if (visible[col][row] == 'v')
                        g2.drawImage(sprites.get(minefield[col][row]), offsetX + col * 32, offsetY + row * 32, null);
                    else if (visible[col][row] == 'f')
                        g2.drawImage(sprites.get('f'), offsetX + col * 32, offsetY + row * 32, null);
                    else if (visible[col][row] == 'h')
                        g2.drawImage(sprites.get('h'), offsetX + col * 32, offsetY + row * 32, null);
                } else {
                    g2.drawImage(sprites.get(minefield[col][row]), offsetX + col * 32, offsetY + row * 32, null);
                    String str = "Game Over!";
                    int w = (int) getFontMetrics(gameFont).getStringBounds(str, null).getWidth();
                    g2.drawString(str, ((int) (this.getSize().getWidth() / 2 - w / 2)), ((int) (this.getSize().getHeight() - 200)));
                }
            }
        }
        if (won) {
            g2.setColor(Color.GREEN);
            String str = "Game Won!";
            int w = (int) getFontMetrics(gameFont).getStringBounds(str, null).getWidth();
            g2.drawString(str, ((int) (this.getSize().getWidth() / 2 - w / 2)), ((int) (this.getSize().getHeight() - 200)));
        }
    }

    public void uncover(int row, int col, boolean flagIt) {
        // System.out.printf("User clicked on row %d and col %d, flagging %b\n", row, col, flagIt);
        // now implement the game mechanics here:
        if (flagIt) {
            if (visible[col][row] != 'f') {
                visible[col][row] = 'f';
                checkIfWon();
            } else visible[col][row] = 'h';
        } else if (visible[col][row] != 'f') {
            // check for bomb
            if (minefield[col][row] == 'b') {
                // game over
                visible[col][row] = 'v';
                gameOver = true;
            } else {
                visible[col][row] = 'v';
                if (minefield[col][row] == '0') {
                    // auto-uncover ...
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int c = col + x;
                            int r = row + y;
                            if (c >= 0 && r >= 0 && c < cols && r < rows) { // check for the edges
                                if (visible[c][r] == 'h') uncover(r, c, false);
                            }
                        }
                    }

                }
            }
        }

        repaint();
    }

    private void checkIfWon() {
        won = true;
        for (int col = 0; col < visible.length; col++) {
            for (int row = 0; row < visible[col].length; row++) {
                if (minefield[col][row] == 'b') {
                    if (visible[col][row]!='f') {
                        won = false;
                    }
                }
            }
        }
    }
}
