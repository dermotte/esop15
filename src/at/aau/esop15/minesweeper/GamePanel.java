package at.aau.esop15.minesweeper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

/**
 * This is an extended version of the Minesweeper from the lecture with restart and the ability to put it into a jar file.
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 14.01.2016 14:15.
 */
public class GamePanel extends JPanel {
    int row = 25, col = 25;
    char[][] mineField = new char[row][col];
    char[][] userView = new char[row][col];

    HashMap<Character, BufferedImage> assets;

    boolean gameOver = false;
    boolean won = false;

    Font gameFont;

    public GamePanel(int rows, int cols) {
        row = rows;
        col = cols;
        init();

        // pre load assets
        assets = new HashMap<>(12);
        try {
            assets.put('b', ImageIO.read(GamePanel.class.getResource("images/Bomb.png")));
            assets.put('0', ImageIO.read(GamePanel.class.getResource("images/Base-Grey.png")));
            assets.put('1', ImageIO.read(GamePanel.class.getResource("images/1.png")));
            assets.put('2', ImageIO.read(GamePanel.class.getResource("images/2.png")));
            assets.put('3', ImageIO.read(GamePanel.class.getResource("images/3.png")));
            assets.put('4', ImageIO.read(GamePanel.class.getResource("images/4.png")));
            assets.put('5', ImageIO.read(GamePanel.class.getResource("images/5.png")));
            assets.put('6', ImageIO.read(GamePanel.class.getResource("images/6.png")));
            assets.put('7', ImageIO.read(GamePanel.class.getResource("images/7.png")));
            assets.put('8', ImageIO.read(GamePanel.class.getResource("images/8.png")));
            assets.put('h', ImageIO.read(GamePanel.class.getResource("images/Beveled.png")));
            assets.put('f', ImageIO.read(GamePanel.class.getResource("images/Flag.png")));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = e.getY() / 32;
                int c = e.getX() / 32;
//                System.out.printf("button %d, x %d, y %d, col/row = %d/%d\n",
//                        e.getButton(), e.getX(), e.getY(), c, r);
                interact(c, r, e.getButton());
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_N) {
                    init();
                    gameOver = false;
                    won = false;
                }
            }
        });
        gameFont = new Font("Verdana", Font.BOLD, 64);
        setPreferredSize(new Dimension(col * 32, row * 32));
    }

    private void init() {
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
                if (Math.random() < 0.15)
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
    }

    private void interact(int c, int r, int button) {
        if (c < col && r < row && !gameOver && !won) {
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
                    checkIfWon();
                } else if (userView[r][c] == 'f') {
                    userView[r][c] = 'h';
                }
            } else if (button == 2) {
                // count flags ...
                int flags = 0;
                for (int ii = -1; ii <= 1; ii++) {
                    for (int jj = -1; jj <= 1; jj++) {
                        if (r + ii >= 0 && r + ii < row && c + jj >= 0 && c + jj < col) {
                            if (userView[r + ii][c + jj] == 'f') flags++;
                        }
                    }
                }
                // System.out.println("flags = " + flags);
                if (userView[r][c] != 'h' && mineField[r][c] == Integer.toString(flags).charAt(0)) {
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

    private void checkIfWon() {
        won = true;
        for (int col = 0; col < userView.length; col++) {
            for (int row = 0; row < userView[col].length; row++) {
                if (mineField[col][row] == 'b') {
                    if (userView[col][row] != 'f') {
                        won = false;
                    }
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(gameFont);
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
        if (gameOver) {
            g2.setColor(Color.RED);
            String str = "Game Over!";
            int w = (int) getFontMetrics(gameFont).getStringBounds(str, null).getWidth();
            g2.drawString(str, ((int) (this.getSize().getWidth() / 2 - w / 2)), ((int) (this.getSize().getHeight() / 2 + gameFont.getSize() / 2)));
        }
        if (won) {
            g2.setColor(Color.GREEN);
            String str = "Game Won!";
            int w = (int) getFontMetrics(gameFont).getStringBounds(str, null).getWidth();
            g2.drawString(str, ((int) (this.getSize().getWidth() / 2 - w / 2)), ((int) (this.getSize().getHeight() / 2 + gameFont.getSize() / 2)));
        }
        if (won || gameOver) {
            g2.setColor(Color.black);
            String str = "Press <SPACE> for new game.";
            Font f = gameFont.deriveFont(22f).deriveFont(Font.BOLD);
            g2.setFont(f);
            g2.fillRect(0, ((int) (this.getSize().getHeight() / 2 + (gameFont.getSize() * 1.5f))), ((int) getSize().getWidth()), gameFont.getSize());
            int w = (int) getFontMetrics(f).getStringBounds(str, null).getWidth();
            g2.setColor(Color.white);
            g2.drawString(str, ((int) (this.getSize().getWidth() / 2 - w / 2)), ((int) (this.getSize().getHeight() / 2 + gameFont.getSize() *2)));
        }
    }

    public void newGame() {
        gameOver = false;
        won = false;
        init();
    }
}
