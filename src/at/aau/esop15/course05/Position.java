package at.aau.esop15.course05;

/**
 * @author Dr. Mathias Lux, 02.11.2015.
 */
public class Position {
    double x;
    double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        y++;
    }

    public static void main(String[] args) {
        Position p = new Position(10, 10);
        p.moveLeft();
        p.moveLeft();
    }
}
