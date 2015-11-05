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

    public double distance(Position p) {
        double r = 0;
        r = (p.x -x)*(p.x -x) + (p.y-y)*(p.y-y);
        return Math.sqrt(r);
    }

    public static void main(String[] args) {
        Position p = new Position(10, 10);
        p.moveLeft();
        p.moveLeft();

        Position p2 = new Position(10, 10);
        if (p2.distance(p) < 1) System.out.println("nahe");
        else System.out.println("fern");
    }
}
