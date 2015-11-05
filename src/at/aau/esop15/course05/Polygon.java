package at.aau.esop15.course05;

class Point {
    int x,y;
}

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 05.11.2015 14:39.
 */
public class Polygon {
    Point[] pointArray;
    int strokeColor;
    int fillColor;

    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        polygon.pointArray = new Point[3];
        polygon.pointArray[0] = new Point();
        polygon.pointArray[0].x = 42;
        polygon.pointArray[0].y = 7;

        System.out.println("Hello World!");
    }
}
