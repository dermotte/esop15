package at.aau.esop15.course11;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * Created by mlux on 15.12.2015.
 */
public class SimplePaint extends JPanel {
    JFrame mainFrame;
    ColorPicker colorPicker;
    LinkedList<Point> points = new LinkedList<>();

    public SimplePaint(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                addPoint(e.getPoint());
            }

        });

        Thread runner = new Thread(() -> {
            while (true) repaint(120);
        });
        runner.start();
    }

    private void addPoint(Point point) {
        points.add(point);
    }

    public static void main(String[] args) {
        final JFrame main = new JFrame("Simple Java Paint");
        main.setSize(640, 480);
        SimplePaint simplePaint = new SimplePaint(main);

        final JFXPanel fxPanel = new JFXPanel();
        Platform.runLater(() -> {
            ColorPicker cp1 = new ColorPicker();
            Scene sc = new Scene(cp1);
            fxPanel.setScene(sc);
            simplePaint.setColorPicker(cp1);
        });
        main.getContentPane().add(fxPanel, BorderLayout.NORTH);
        main.getContentPane().add(simplePaint, BorderLayout.CENTER);

        main.setVisible(true);
    }

    public void setColorPicker(ColorPicker colorPicker) {
        this.colorPicker = colorPicker;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        while (!points.isEmpty()) {
            if (colorPicker != null) {
                javafx.scene.paint.Color val = colorPicker.getValue();
                Color pc = new Color((float) val.getRed(), (float) val.getGreen(), (float) val.getBlue());
                g2.setColor(pc);
            }
            Point p = points.removeFirst();
            g2.fillOval(p.x, p.y, 5, 5);
        }
    }
}
